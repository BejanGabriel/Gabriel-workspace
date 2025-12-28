package dao;

import java.util.List;

import model.Utente;

public interface UtenteDAO {

	boolean create(Utente utente);
	Utente readByID(int id);
	List<Utente> readAll();
	boolean update(Utente utente);
	boolean deleteByID(int id);
}
