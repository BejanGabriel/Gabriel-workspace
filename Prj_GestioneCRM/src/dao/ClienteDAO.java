package dao;

import java.util.List;

import model.Cliente;

public interface ClienteDAO {

	boolean create(Cliente cliente);
	Cliente readByID(int id);
	List<Cliente> readAll();
	boolean update(Cliente cliente);
	boolean deleteByID(int id);
	boolean assegnazioneByID(int idSet, int idWhere);

}
