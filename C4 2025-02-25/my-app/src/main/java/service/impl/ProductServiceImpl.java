package service.impl;

import java.util.List;

import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService{
		private static ProductDaoImpl productdaoimpl = new ProductDaoImpl();
	@Override
	public String AllProduct() {
		List<Product> l = productdaoimpl.selectAll();
		String show = new String();
		show = "";
		for(Product p : l) {
			show += "ID:"+p.getProductID()+"  商品:"+p.getProductname()+"\t價格:"+p.getPrice()+"\n";
		}

		return show;
		
	}
	@Override
	public void updateProduct(int productID, String productname, int price) {
		 Product p = productdaoimpl.selectById(productID);;
		 p.setProductname(productname);
		 p.setPrice(price);
		 productdaoimpl.update(p);
		
	}

}
