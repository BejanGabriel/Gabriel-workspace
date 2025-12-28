package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Utente;
import utilitis.RiferimentoConnessione;

public class UtenteDAOImpl extends RiferimentoConnessione implements UtenteDAO{
	
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
				
				allUtenti.add(utente);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return allUtenti;
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
