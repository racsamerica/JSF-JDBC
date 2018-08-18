package edu.upc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.upc.dao.PhoneDao;
import edu.upc.entity.Customer;
import edu.upc.entity.Phone;

public class PhoneImpl implements PhoneDao {

	private Connection oCn;

	public PhoneImpl() {
		oCn = Conexion.AbrirConexion();
	}


	public void insertar(List<Phone> listaTelefonos) throws Exception  {
		try {
			
			oCn.setAutoCommit(false);
			for (Phone tel : listaTelefonos) {
				String sql = "INSERT INTO phone(numberPhone,idCustomer) VALUES (?,?)";
				PreparedStatement ps = oCn.prepareStatement(sql);
				ps.setString(1,tel.getNumberPhone());
				ps.setInt(2, tel.getCustomer().getIdCustomer());
				ps.executeUpdate();
				ps.close();
			}
			oCn.commit();
		} catch (Exception e) {
			oCn.rollback();
			e.printStackTrace();
		}
	}

	public List<Phone> listar() throws Exception {
		List<Phone> lista = new ArrayList<>();
		try {
			String sql = "SELECT p.idPhone, p.idCustomer, p.numberPhone, c.nameCustomer "
					+ "FROM phone p join customer c on p.idCustomer = c.idCustomer";
			PreparedStatement ps = oCn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				Phone p = new Phone();
				Customer c = new Customer();
				p.setIdPhone(rs.getInt("idPhone"));
				p.setNumberPhone(rs.getString("numberPhone"));
				c.setIdCustomer(rs.getInt("idCustomer"));
				c.setNameCustomer(rs.getString("nameCustomer"));
							
				p.setCustomer(c);
			    lista.add(p);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
}
