package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import model.Product;
import util.DbConnection;

public class ProductDaoImpl implements ProductDao {

	private static Connection conn = DbConnection.getDb();

	@Override
	public List<Product> selectAll() {
		String sql = "select * from product";
		List<Product> l = new ArrayList<>();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Product product = new Product();
				product.setProductID(resultset.getInt("productID"));
				product.setProductname(resultset.getString("productname"));
				product.setPrice(resultset.getInt("price"));
				l.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public Product selectById(int productID) {
	    String sql = "SELECT * FROM product WHERE productID = ?";
	    Product product = null; // 初始化為 null，確保找不到時回傳 null
	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.setInt(1, productID);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) { // 只有一筆資料時，直接取出
	            product = new Product();
	            product.setProductID(resultSet.getInt("productID"));
	            product.setProductname(resultSet.getString("productname"));
	            product.setPrice(resultSet.getInt("price"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return product; // 直接回傳 Product
	}

	@Override
	public void update(Product product) {
		String sql = "update product set productname = ?,price = ? where productID = ?" ;
		System.out.println(product);
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
		
			preparedstatement.setString(1,product.getProductname());
			preparedstatement.setInt(2, product.getPrice());
			preparedstatement.setInt(3, product.getProductID());
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
