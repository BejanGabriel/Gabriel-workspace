package dao;

import java.util.List;

import model.Appuntamento;

public interface AppuntamentoDAO {

	boolean create(Appuntamento appuntamento);
	Appuntamento readByID(int id);
	List<Appuntamento> readAll();
	boolean update(Appuntamento appuntamento);
	boolean deleteByID(int id);
	List<Appuntamento> readyByUtenteID(int idCliente);
}
