package edu.upc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import edu.upc.dao.PhoneDao;
import edu.upc.dao.impl.PhoneImpl;
import edu.upc.entity.Customer;
import edu.upc.entity.Phone;




@ManagedBean
@ViewScoped
public class PhoneBean implements Serializable {

	private int idCustomer;
	private Customer customer;
	private Phone phone;
	private List<Phone> listaTelefonos;
	private PhoneDao pdao;
	
	@ManagedProperty(value = "#{customerBean}")
	private CustomerBean customerBean;

	public PhoneBean() {
		
		phone = new Phone();
		listaTelefonos = new ArrayList<>();
		pdao = new PhoneImpl();
	}

	@PostConstruct
	public void init() {
		customerBean.listar();
	}

	
	public void agregar() {
		Phone p = new Phone();
		p.setIdPhone(phone.getIdPhone());
		p.setNumberPhone(phone.getNumberPhone());

		
		p.setCustomer(customer);		
		listaTelefonos.add(p);
	}
	public void insertar() {
		try {
			pdao.insertar(listaTelefonos);
			listaTelefonos.clear();
			this.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void listar() {
		try {
			listaTelefonos = pdao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Metodos set-get menos del dao, para el customerbean solo el set porque
	// Importante para la inyeccion de dependencia, este metodo se invoca al 
	//momento que se ejecuta el postconstruct y se realiza la inyeccion de dependencia
	
	
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}

 	public int getIdCustomer() {
		return idCustomer;
	}

	

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public List<Phone> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(List<Phone> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	
	
	
	
	
	
}
