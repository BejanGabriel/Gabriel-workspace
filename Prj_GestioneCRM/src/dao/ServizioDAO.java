package dao;

import java.util.List;

import model.Nota;
import model.Servizio;

public interface ServizioDAO {
	
	boolean create(Servizio servizio);
	Servizio readByID(int id);
	List<Servizio> readAll();
	boolean update(Servizio servizio);
	boolean deleteByID(int id);
	List<Servizio> readByClienteID(int idCliente);
	boolean associaClienteServizio(int idCliente, int idServizio);
	
}
