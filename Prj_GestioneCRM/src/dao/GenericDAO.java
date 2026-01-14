package dao;

import java.util.List;

import model.Nota;

public interface GenericDAO<T> {
	
	boolean create(T entity);
	T readByID(int id);
	List<T> readAll();
	boolean update(T entity);
	boolean deleteByID(int id);
	List<Nota> readByClienteID(int idCliente);
	
	
}
