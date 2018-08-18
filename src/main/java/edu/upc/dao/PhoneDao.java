package edu.upc.dao;

import java.util.List;

import edu.upc.entity.Phone;



public interface PhoneDao {
	public void insertar(List<Phone> listaTelefonos) throws Exception ;
	public List<Phone> listar() throws Exception ;

}
