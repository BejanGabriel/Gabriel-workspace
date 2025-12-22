package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Utente;
import utilitis.RiferimentoConnessione;

public class UtenteDAOImpl extends RiferimentoConnessione implements GenericDAO<Utente> {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	

	public UtenteDAOImpl() {

	}

	@Override
	public boolean create(Utente utente) {
		try {
			ps = conn.prepareStatement("INSERT INTO utente (nome_utente, ruolo, email, password)"
					+ "VALUES (?, ?, ?, ?);");
			ps.setString(1, utente.getNomeUtente());
			ps.setString(2, utente.getRuolo());
			ps.setString(3, utente.getEmail());
			ps.setString(4, utente.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Utente readByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Utente utente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
