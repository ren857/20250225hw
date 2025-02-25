package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Hw;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao {
	private static Connection conn = DbConnection.getDb();

	@Override
	public void addporder(Porder porder) {
		String sql = "insert into porder (consmerID,employeeID,productID,amount) values(?,?,?,?)";
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);

			preparedstatement.setInt(1, porder.getConsmerID()); // 購買人 ID
			preparedstatement.setInt(2, porder.getEmployeeID()); // 商品 ID
			preparedstatement.setInt(3, porder.getProductID()); // 賣家 ID
			preparedstatement.setInt(4, porder.getAmount()); // 商品數量
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Porder porder) {
		String sql = "update porder set consmerID = ?,employeeID = ?, productID = ?,amount = ? where porderID = ?";
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1, porder.getConsmerID());
			preparedstatement.setInt(2, porder.getEmployeeID());
			preparedstatement.setInt(3, porder.getProductID());
			preparedstatement.setInt(4, porder.getAmount());
			preparedstatement.setInt(5, porder.getPorderID());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int queryporderID() {
		String sql = "select MAX(porderID) from porder";

		int MaxPorderID = 0;

		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);

			ResultSet rs = preparedstatement.executeQuery();
			if (rs.next()) {
				MaxPorderID = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MaxPorderID;
	}

	@Override
	public void delete(int porderID) {
		String sql = "delete from porder where porderID= ?";
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1, porderID);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Hw> getOrdersByConsmer(String consmername) {
		List<Hw> l = new ArrayList<>();
		String sql = "SELECT * FROM hw5.hw WHERE consmerID IN " + "(SELECT consmerID FROM hw5.consmer WHERE name = ?)";

		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, consmername);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Hw h = new Hw();
				h.setPorderID(resultset.getInt("porderID"));				
				h.setConsmername(resultset.getString("consmername"));
				h.setConsmerID(resultset.getInt("consmerID"));
				h.setPhone(resultset.getString("phone"));
				h.setAddress(resultset.getString("address"));
				h.setEmployeename(resultset.getString("employeename"));
				h.setProductname(resultset.getString("productname"));
				h.setAmount(resultset.getInt("amount"));
				h.setPrice(resultset.getInt("price"));
				h.setSum(resultset.getInt("sum"));
				l.add(h);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

}
