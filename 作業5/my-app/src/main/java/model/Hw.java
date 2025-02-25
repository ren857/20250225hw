package model;

public class Hw {
		private Integer PorderID;
		private String consmername;
		private Integer consmerID;
		private String phone;
		private String address;
		private String employeename;
		private String productname;
		private Integer amount;
		private Integer price;
		private Integer sum;
		public Hw(String consmername, Integer consmerID, String phone, String address, String employeename,
				String productname, Integer amount, Integer price, Integer sum) {
			super();
			this.consmername = consmername;
			this.consmerID = consmerID;
			this.phone = phone;
			this.address = address;
			this.employeename = employeename;
			this.productname = productname;
			this.amount = amount;
			this.price = price;
			this.sum = sum;
		}
		public Hw() {
			super();
		}
		public Integer getPorderID() {
			return PorderID;
		}
		public void setPorderID(Integer porderID) {
			PorderID = porderID;
		}
		public String getConsmername() {
			return consmername;
		}
		public void setConsmername(String consmername) {
			this.consmername = consmername;
		}
		public Integer getConsmerID() {
			return consmerID;
		}
		public void setConsmerID(Integer consmerID) {
			this.consmerID = consmerID;
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
		public String getEmployeename() {
			return employeename;
		}
		public void setEmployeename(String employeename) {
			this.employeename = employeename;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getSum() {
			return sum;
		}
		public void setSum(Integer sum) {
			this.sum = sum;
		}
		
}
