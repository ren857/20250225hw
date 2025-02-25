package dao;

import java.util.List;


import model.Product;

public interface ProductDao {
	
	List<Product>selectAll();
	Product selectById(int productID);
	void update (Product product);
}
