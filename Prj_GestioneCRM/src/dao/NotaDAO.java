package dao;

import java.util.List;

import model.Nota;

public interface NotaDAO {

	boolean create(Nota nota);
	Nota readByID(int id);
	List<Nota> readAll();
	boolean update(Nota nota);
	boolean deleteByID(int id);
	List<Nota> readByClienteID(int idCliente);
}
