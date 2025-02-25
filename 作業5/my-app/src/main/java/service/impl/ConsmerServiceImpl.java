package service.impl;

import java.util.List;
import java.util.regex.Pattern;

import dao.impl.ConsmerDaoImpl;
import model.Consmer;
import service.ConsmerService;

public class ConsmerServiceImpl implements ConsmerService {
	private static ConsmerDaoImpl consmerdaoimpl = new ConsmerDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidUsername(String username) {
		// 檢查帳號是否包含英文字母和數字
		String regex = "^[A-Za-z][0-9A-Za-z]{0,11}$";
		return Pattern.matches(regex, username);
	}

	public boolean isValidPassword(String password) {
		// 檢查密碼是否僅包含數字
		String regex = "^\\d+$";
		return Pattern.matches(regex, password);
	}

	public boolean isValidPhone(String phone) {
		String regex = "^\\d+$";
		System.out.println("phone = "+phone);
		return Pattern.matches(regex, phone);
	}

	@Override
	public void addConsmer(Consmer consmer) {
		if (isValidUsername(consmer.getUsername()) && isValidPassword(consmer.getPassword())
				&& isValidPhone(consmer.getPhone())) {
//			System.out.print("YES");
			consmerdaoimpl.add(consmer);
		} else {
			System.out.println("Username or password format is invalid.");
		}

	}

	@Override
	public Consmer Login(String username, String password) {
		if (isValidUsername(username) && isValidPassword(password)) {
			Consmer consmer = null;
			List<Consmer> l = consmerdaoimpl.selectUsernameAndPassword(username, password);
			if (l.size() != 0) {
				consmer = l.get(0);
			}

			return consmer;
		} else {
			System.out.println("Login failed due to invalid username or password.");
			return null;
		}
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		
		return !consmerdaoimpl.selectByUsername(username).isEmpty();
	}

}
