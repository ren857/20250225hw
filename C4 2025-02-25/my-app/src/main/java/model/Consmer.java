package model;

import java.io.Serializable;

public class Consmer implements Serializable{
		private Integer consmerID;
		private String name;
		private String username;
		private String password;
		private String phone;
		private String address;
		public Consmer(String name, String username, String password, String address, String phone) {
			super();
			this.name = name;
			this.username = username;
			this.password = password;
			this.phone = phone;
			this.address = address;
			
		}
		 public Consmer(String name, String username, String password, String address, String phone, Integer consmerID) {
		        super();
		        this.name = name;
		        this.username = username;
		        this.password = password;
		        this.phone = phone;
		        this.address = address;
		        this.consmerID = consmerID;
		 }
		public Consmer() {
			super();
		}
		public Integer getConsmerID() {
			return consmerID;
		}
		public void setConsmerID(Integer consmerID) {
			this.consmerID = consmerID;
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
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
}
