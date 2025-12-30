package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Appuntamento;
import shortCuts.Utilitys;

public class AppuntamentoDAOImpl extends Utilitys implements AppuntamentoDAO{

	private PreparedStatement ps;
	private ResultSet rs;

	public AppuntamentoDAOImpl() {
	}

	@Override
	public boolean create(Appuntamento appuntamento) {
		// id_appuntament(col-1) è gia automaticamente gestita da mysql.
		// appuntamento ha 2 foreign key, id_cliente(col-2) e utente_associato(col-5)
		try {
			ps = conn.prepareStatement(
					"INSERT INTO appuntamento (id_cliente, descrizione, utente_associato)"
							+ " value (?,?,?);");
			ps.setInt(1, appuntamento.getIdCliente());
			ps.setString(2, appuntamento.getDescrizione());
			ps.setInt(3, appuntamento.getUtenteAssociato());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Appuntamento readByID(int id) {
		Appuntamento a = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM appuntamento WHERE id_appuntamento = ?);");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				a = new Appuntamento();
				a.setIdAppuntamento(rs.getInt("id_appuntamento"));
				a.setIdCliente(rs.getInt("id_cliente"));
				a.setDescrizione(rs.getString("descrizione"));
				a.setUtenteAssociato(rs.getInt("utente_associato"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Appuntamento> readAll() {
		List<Appuntamento> appuntamenti = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT * FROM appuntamento;");
			rs = ps.executeQuery();
			while(rs.next()) {
				Appuntamento a = new Appuntamento();
				a.setIdAppuntamento(rs.getInt("id_appuntamento"));
				a.setIdCliente(rs.getInt("id_cliente"));
				a.setDataAppuntamento(rs.getDate("data_appuntamento"));
				a.setDescrizione(rs.getString("descrizione"));
				a.setUtenteAssociato(rs.getInt("utente_associato"));
				
				appuntamenti.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appuntamenti;
	}

	@Override
	public boolean update(Appuntamento appuntamento) {
		try {
			ps = conn.prepareStatement("UPDATE appuntamento SET"
					+ " data_appuntamento = ?,"
					+ "descrizione = ?,"
					+ "utente_associato = ?"
					+ "WHERE id_appuntamento = ?;");
			ps.setDate(1, appuntamento.getDataAppuntamento());
			//La data va aggiustata di formato, da fare nel controller di appuntamento.
			ps.setString(2, appuntamento.getDescrizione());
			ps.setInt(3, appuntamento.getUtenteAssociato());
			ps.setInt(4, appuntamento.getIdAppuntamento());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByID(int id) {
			
		try {
			ps = conn.prepareStatement("DELETE FROM appuntamento WHERE id_appuntamento = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
