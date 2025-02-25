package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.EmployeeDao;
import model.Employee;
import util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	private static Connection conn = DbConnection.getDb();

	@Override
	public void add(Employee employee) {

		String sql = "insert into employee(name,username,password,phone)" + "values(?,?,?,?)";
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, employee.getName());
			preparedstatement.setString(2, employee.getUsername());
			preparedstatement.setString(3, employee.getPassword());
			preparedstatement.setString(4, employee.getPhone());

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> selectAll() {
		String sql = "select * from employee";
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Employee e = new Employee();
				e.setEmployeeID(resultset.getInt("employeeID"));
				e.setName(resultset.getString("name"));
				e.setUsername(resultset.getString("username"));
				e.setPassword(resultset.getString("password"));
				e.setPhone(resultset.getString("phone"));
				employees.add(e);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public List<Employee> selectUsernameAndPassword(String username, String password) {
		String sql = "select * from employee where username = ? and password = ?";
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			ResultSet resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				Employee e = new Employee();
				e.setEmployeeID(resultset.getInt("employeeID"));
				e.setUsername(resultset.getString("username"));
				e.setPassword(resultset.getString("password"));
				e.setPhone(resultset.getString("phone"));

				employees.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public Employee selectByUsername(String username) {
		String sql = "select * from employee where username = ?";
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			ResultSet resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				Employee e = new Employee();
				e.setEmployeeID(resultset.getInt("employeeID"));
				e.setName(resultset.getString("name"));
				e.setUsername(resultset.getString("username"));
				e.setPassword(resultset.getString("password"));
				e.setPhone(resultset.getString("phone"));
				return e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployeeById(int employeeID) {
		String sql = "SELECT * FROM employee WHERE employeeID = ?"; // 確保資料表欄位名稱正確
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			{
				preparedstatement.setInt(1, employeeID);
				ResultSet reslutset = preparedstatement.executeQuery();

				if (reslutset.next()) {
					Employee emp = new Employee();
					emp.setEmployeeID(reslutset.getInt("employeeID")); // 確保欄位名稱和 DB 一致
					emp.setName(reslutset.getString("name"));
					return emp;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 查無資料時回傳 null
	}

}
