package service.impl;

import java.util.List;
import java.util.regex.Pattern;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeDaoImpl employeedaoimpl = new EmployeeDaoImpl();

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
		return Pattern.matches(regex, phone);
	}

	@Override
	public void addEmployee(Employee employee) {
		if (isValidUsername(employee.getUsername()) && isValidPassword(employee.getPassword())
				&& isValidPhone(employee.getPhone())) {
			employeedaoimpl.add(employee);
		} else {
			System.out.println("Username or password format is invalid.");
		}

	}

	@Override
	public Employee Login(String username, String password) {
	    if (isValidUsername(username) && isValidPassword(password)) {
	        List<Employee> l = employeedaoimpl.selectUsernameAndPassword(username, password);
	        if (l.size() == 1) {
	            return l.get(0); // 唯一匹配
	        } else {
	            System.out.println("Multiple users found with the same credentials.");
	            return null;
	        }
	    } else {
	        System.out.println("Login failed due to invalid username or password.");
	        return null;
	    }
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		Employee employee = employeedaoimpl.selectByUsername(username);
	    return employee != null; 
	}

}
