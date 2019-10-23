package com.ct.entity;

public class Orders {

	private long orderid;
	private long customerid;
	private String product;
	private String date;
	private int quantity;
	private float unitprice;
	
	public Orders() {
	}

	

	public long getOrderid() {
		return orderid;
	}



	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}



	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}

	public Orders(long orderid, long customerid, String product, String date, int quantity, float unitprice) {
		this.orderid = orderid;
		this.customerid = customerid;
		this.product = product;
		this.date = date;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}
	
	
}
