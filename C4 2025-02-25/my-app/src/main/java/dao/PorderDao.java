package dao;

import java.util.List;

import model.Consmer;
import model.Hw;
import model.Porder;

public interface PorderDao {
	public List<Hw> getOrdersByConsmer(String consmerName);
	int queryporderID();
	void addporder(Porder porder);
	void update (Porder porder);
	void delete(int porderID);
	
}
