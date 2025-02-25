package model;

public class Product {
		private Integer productID;
		private String productname;
		private Integer price;
		public Product(String productname, Integer price) {
			super();
			this.productname = productname;
			this.price = price;
			
		}
		public Product() {
			super();
		}
		public Integer getProductID() {
			return productID;
		}
		public void setProductID(Integer productID) {
			this.productID = productID;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public String toString() {
		    return this.productID+this.productname + " " + this.price + "元";
		}
}
