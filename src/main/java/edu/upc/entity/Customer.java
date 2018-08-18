package edu.upc.entity;

public class Customer {
	private int idCustomer;
	private String nameCustomer;
	public Customer() {
		super();
	}
	public Customer(int idCustomer, String nameCustomer) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	
	

}
