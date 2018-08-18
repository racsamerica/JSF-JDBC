package edu.upc.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.upc.dao.CustomerDao;
import edu.upc.dao.impl.CustomerImpl;
import edu.upc.entity.Customer;

@ManagedBean(name = "customerBean")
@SessionScoped
public class CustomerBean implements Serializable {

	private List<Customer> listaClientes;
	private CustomerDao cdao;
	private Customer customer;
	private String mensaje;

	// Constructor
	public CustomerBean() {
		super();
		cdao = new CustomerImpl();
		customer = new Customer();
		this.listar();
	}

	// Metodos del CRUD
	public void insertarActualizar() {
		int rpta = 0;
		try {
			if (customer.getIdCustomer() > 0) {
				cdao.actualizar(customer);
			} else {
				rpta = cdao.insertar(customer);
			}
			if (rpta == 0 || rpta == 2) {
				mensaje = "Validar git";
			}
			this.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminar(Customer cus) {
		try {
			cdao.eliminar(cus.getIdCustomer());
			listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listar() {
		try {
			listaClientes = cdao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public String listById(Customer c) {
	public void listarId(Customer cus) {
		try {
			customer = cdao.listarId(cus.getIdCustomer());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void limpiar() {
		customer = new Customer();
	}

	// Get y Set ( menos del dao)
	public List<Customer> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Customer> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
