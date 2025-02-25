package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Hw;
import service.PorderService;

public class PorderServiceImpl implements PorderService {
	private PorderDaoImpl porderdaoimpl = new PorderDaoImpl();
	private List<Hw> orders;
	private int totalAmount = 0;

	@Override
	public String displayOrders(String consmername) {
		orders = porderdaoimpl.getOrdersByConsmer(consmername); 
		totalAmount = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("購物清單：\n------------------\n");

		for (Hw order : orders) {
			sb.append("客戶  "+order.getConsmername()+"  產品：" + order.getProductname() + " | 數量：" + order.getAmount() + " | 單價：" + order.getPrice()
					+ " | 總計：" + order.getSum() + " 元\n");
			totalAmount += order.getSum();
		}

		sb.append("\n💰 總金額：" + totalAmount + " 元\n");
		return sb.toString();
	}
	

	@Override
	public String processPayment(int payment) {
		if (payment < totalAmount) {
			return "支付金額不足！";
		}

		int change = payment - totalAmount;
		return "支付金額：" + payment + " 元\n找零：" + change + " 元";
	}

	// 取得總金額
	public int getTotalAmount() {
		return totalAmount;
		
	}

}
