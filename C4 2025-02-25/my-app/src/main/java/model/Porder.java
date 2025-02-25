package model;

public class Porder {
		private Integer porderID;
		private Integer consmerID;
		private Integer productID;
		private Integer employeeID;
		private Integer amount;
		public Porder(Integer consmerID, Integer productID, Integer employeeID, Integer amount ) {
			super();
			 if (consmerID == null) {
		            throw new IllegalArgumentException("Consumer ID cannot be null");
		        }
		        if (productID == null) {
		            throw new IllegalArgumentException("Product ID cannot be null");
		        }
		        if (employeeID == null) {
		            throw new IllegalArgumentException("Employee ID cannot be null");
		        }
		        if (amount == null || amount <= 0) {
		            throw new IllegalArgumentException("Amount must be positive");
		        }
			this.consmerID = consmerID;
			this.productID = productID;
			this.employeeID = employeeID;
			this.amount = amount;
			
		}
		public Porder(Integer consmerID, Integer productID, Integer employeeID, Integer amount,Integer porderID) {
			super();
			this.porderID = porderID;
			this.consmerID = consmerID;
			this.productID = productID;
			this.employeeID = employeeID;
			this.amount = amount;
		}
		public Porder() {
			super();
		}
		public Integer getPorderID() {
			return porderID;
		}
		public void setPorderID(Integer porderID) {
			this.porderID = porderID;
		}
		public Integer getConsmerID() {
			return consmerID;
		}
		public void setConsmerID(Integer consmerID) {
			this.consmerID = consmerID;
		}
		public Integer getProductID() {
			return productID;
		}
		public void setProductID(Integer productID) {
			this.productID = productID;
		}
		public Integer getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(Integer employeeID) {
			this.employeeID = employeeID;
		}
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
		
		
}
