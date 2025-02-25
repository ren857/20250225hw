package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
		//create
		public Employee getEmployeeById(int employeeID);
		void add(Employee employee);
		//read
		List<Employee>selectAll();
		List<Employee>selectUsernameAndPassword(String username,String password);
		public Employee selectByUsername(String username);
		
		//update
		
		//delete
	

}
