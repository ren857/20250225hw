package service;

import java.util.List;

import model.Hw;

public interface PorderService {
	
	public String displayOrders(String consmerName);
	public String processPayment(int payment);
}
