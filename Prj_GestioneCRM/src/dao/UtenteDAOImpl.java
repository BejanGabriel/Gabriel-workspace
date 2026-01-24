package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Utente;
import shortCuts.Scorciatoia;

public class UtenteDAOImpl extends Scorciatoia implements UtenteDAO{
	
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
			int rows = ps.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB nel creare l'utente!:  ", e);
		}
	}

	@Override
	public Utente readByID(int id) {
		try {
			ps = conn.prepareStatement("SELECT * FROM utente WHERE id_utente = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Utente u = new Utente();
				u.setIdUtente(rs.getInt("id_utente"));
				u.setNomeUtente(rs.getString("nome_utente"));
				u.setEmail(rs.getString("email"));
				u.setRuolo(rs.getString("ruolo"));
				u.setPassword(rs.getString("password"));
				u.setDataRegistrazione(rs.getDate("data_registrazione"));
				return u;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB con la ricerca del singolo utente ", e);
		}
	}

	@Override
	public List<Utente> readAll() {
		List<Utente> allUtenti = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT * FROM utente;");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Utente utente = new Utente();
				utente.setIdUtente(rs.getInt("id_utente"));
				utente.setNomeUtente(rs.getString("nome_utente"));
				utente.setRuolo(rs.getString("ruolo"));
				utente.setEmail(rs.getString("email"));
				utente.setPassword(rs.getString("password"));
				utente.setDataRegistrazione(rs.getDate("data_registrazione"));
				
				allUtenti.add(utente);
				
			}
			
			return allUtenti;
			
		} catch (SQLException e) {
			//lacio un errore a runtime per gestire due possibili errori, se la lista utenti sia vuota o se il db è brasato.
			throw new RuntimeException("Errore nel DB durante lettura Utenti: ", e);
		}
	}

	@Override
	public boolean update(Utente utente) {
		try {
			ps = conn.prepareStatement("UPDATE utente SET "
					+ "nome_utente = ?,"
					+ "ruolo = ?,"
					+ "email = ?,"
					+ "password = ?"
					+ "WHERE id_utente = ?");
			ps.setString(1, utente.getNomeUtente());
			ps.setString(2, utente.getRuolo());
			ps.setString(3, utente.getEmail());
			ps.setString(4, utente.getPassword());
			ps.setInt(5, utente.getIdUtente());
			int rows = ps.executeUpdate();
			return rows > 0;
			
		}catch (SQLException e) {
			throw new RuntimeException("Errore nel  DB durante l'update!", e);
		}
	}

	@Override
	public boolean deleteByID(int id) {
		try {
			ps = conn.prepareStatement("DELETE FROM utente WHERE id_utente = ?");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			//mi faccio restituire le righe coinvolte, se sono < 0 non è stato modificato nulla, se > 0 si.
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore nel DB! durante eliminazione utente!");
		}
	}

}
