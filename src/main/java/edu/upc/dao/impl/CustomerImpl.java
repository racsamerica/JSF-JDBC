package edu.upc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.upc.dao.CustomerDao;
import edu.upc.entity.Customer;

public class CustomerImpl implements CustomerDao {

	private Connection oCn;

	public CustomerImpl() {
		oCn = Conexion.AbrirConexion();
	}

	@Override
	public int insertar(Customer customer) {
		int rpta=0;
		try {
			int a=0;
			String buscar = "select count(*) as cantidad from customer where nameCustomer=?";
			PreparedStatement ps = oCn.prepareStatement(buscar);
			ps.setString(1, customer.getNameCustomer());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				a = rs.getInt("cantidad");
				System.out.println(a);
			}
			if (a == 0) {
				String sql = "INSERT INTO customer(nameCustomer) VALUES(?)";
				PreparedStatement ps1 = oCn.prepareStatement(sql);
				ps1.setString(1, customer.getNameCustomer());
				ps1.executeUpdate();
				ps1.close();
				rpta=1;
			}else {
				rpta=2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rpta=0;
		}
		return rpta;
	}

	@Override
	public void eliminar(int idCustomer) {
		try {
			String sql = "DELETE FROM customer Where idCustomer=?";
			PreparedStatement ps = oCn.prepareStatement(sql);
			ps.setInt(1, idCustomer);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(Customer customer) {
		try {
			String sql = "UPDATE customer SET nameCustomer=? WHERE idCustomer=?";
			PreparedStatement ps = oCn.prepareStatement(sql);
			ps.setString(1, customer.getNameCustomer());
			ps.setInt(2, customer.getIdCustomer());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> listar() {

		List<Customer> lista = new ArrayList<>();

		try {

			String sql = "select * from customer";
			PreparedStatement ps = oCn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				Customer c = new Customer();
				c.setIdCustomer(rs.getInt("idCustomer"));
				c.setNameCustomer(rs.getString("nameCustomer"));
				lista.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Customer listarId(int idCustomer) {
		Customer c = new Customer();
		try {
			String sql = "SELECT idCustomer,nameCustomer FROM customer WHERE idCustomer =?";
			PreparedStatement ps = oCn.prepareStatement(sql);
			ps.setInt(1, idCustomer);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c.setIdCustomer(rs.getInt("idCustomer"));
				c.setNameCustomer(rs.getString("nameCustomer"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
