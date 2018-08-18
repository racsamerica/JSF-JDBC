package edu.upc.entity;


public class Phone {
	private int idPhone;
	private String numberPhone;
	private Customer customer;
	public Phone() {
		super();
	}
	public Phone(int idPhone, String numberPhone, Customer customer) {
		super();
		this.idPhone = idPhone;
		this.numberPhone = numberPhone;
		this.customer = customer;
	}
	public int getIdPhone() {
		return idPhone;
	}
	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
