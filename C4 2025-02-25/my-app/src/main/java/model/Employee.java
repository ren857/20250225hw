package model;

import java.io.Serializable;

public class Employee implements Serializable{
		private Integer employeeID;
		private String name;
		private String username;
		private String password;
		private String phone;
		public Employee(String name, String username, String password, String phone,Integer employeeID) {
			super();
			this.name = name;
			this.username = username;
			this.password = password;
			this.phone = phone;
			this.employeeID = 1; 
		}
		public Employee() {
			super();
		}
		
		public Integer getEmployeeID() {
			if (employeeID == null) {
	           
	        }
			return employeeID;
		}
		public void setEmployeeID(Integer employeeID) {
			this.employeeID = employeeID;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public String toString() {
	        return name; // 返回員工的名字或其他屬性
		}
}
