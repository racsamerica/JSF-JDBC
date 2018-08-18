package edu.upc.dao;

import java.util.List;

import edu.upc.entity.Customer;

public interface CustomerDao {

	public int insertar(Customer customer);

	public void eliminar(int idCustommer);

	public void actualizar(Customer customer);

	public List<Customer> listar();

	public Customer listarId(int idCustomer);
}
