package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Utente;
import utilitis.RiferimentoConnessione;

public class UtenteDAOImpl extends RiferimentoConnessione implements GenericDAO<Utente>, Associazioni{
	
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
		Utente u = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM utente WHERE id_utente = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new Utente();
				u.setIdUtente(rs.getInt("id_utente"));
				u.setNomeUtente(rs.getString("nome_utente"));
				u.setEmail(rs.getString("email"));
				u.setRuolo(rs.getString("ruolo"));
				u.setPassword(rs.getString("password"));
				u.setDataRegistrazione(rs.getDate("data_registrazione"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
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

	@Override
	public boolean assegnazioneByID(int idSet, int idWhere) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean associazioneById(int idSet, int idWhere) {
		// TODO Auto-generated method stub
		return false;
	}

}
