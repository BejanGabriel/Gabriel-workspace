package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Appuntamento;
import shortCuts.Scorciatoia;

public class AppuntamentoDAOImpl extends Scorciatoia implements AppuntamentoDAO {

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
					"INSERT INTO appuntamento (id_cliente, descrizione, utente_associato)" + " VALUE (?,?,?);");
			ps.setInt(1, appuntamento.getIdCliente());
			ps.setString(2, appuntamento.getDescrizione());
			ps.setInt(3, appuntamento.getUtenteAssociato());
			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la creazione appuntamento!  " + e);
		}
	}

	@Override
	public Appuntamento readByID(int id) {
		try {
			ps = conn.prepareStatement("SELECT * FROM appuntamento WHERE id_appuntamento = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Appuntamento a = new Appuntamento();
				a.setIdAppuntamento(rs.getInt("id_appuntamento"));
				a.setIdCliente(rs.getInt("id_cliente"));
				a.setDescrizione(rs.getString("descrizione"));
				a.setUtenteAssociato(rs.getInt("utente_associato"));

				return a;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la ricerca dell'appuntamento!  " + e);
		}
	}

	@Override
	public List<Appuntamento> readAll() {
		List<Appuntamento> appuntamenti = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT * FROM appuntamento;");
			rs = ps.executeQuery();
			while (rs.next()) {
				Appuntamento a = new Appuntamento();
				a.setIdAppuntamento(rs.getInt("id_appuntamento"));
				a.setIdCliente(rs.getInt("id_cliente"));
				a.setDataAppuntamento(rs.getDate("data_appuntamento"));
				a.setDescrizione(rs.getString("descrizione"));
				a.setUtenteAssociato(rs.getInt("utente_associato"));

				appuntamenti.add(a);
			}

			return appuntamenti;

		} catch (SQLException e) {
			throw new RuntimeException("Errore nella lettura degli appuntamenti nel DB! " + e);
		}
	}

	@Override
	public boolean update(Appuntamento appuntamento) {
		try {
			ps = conn.prepareStatement("UPDATE appuntamento SET "
//					+ "data_appuntamento = ?,"
					+ "descrizione = ?, " + "utente_associato = ? " + "WHERE id_appuntamento = ?;");
//			ps.setDate(1, appuntamento.getDataAppuntamento());
			// La data va aggiustata di formato, da fare nel controller di appuntamento.
			ps.setString(1, appuntamento.getDescrizione());
			ps.setInt(2, appuntamento.getUtenteAssociato());
			ps.setInt(3, appuntamento.getIdAppuntamento());
			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante l'aggiornamento dell'appuntamento!  " + e);
		}
	}

	@Override
	public boolean deleteByID(int id) {

		try {
			ps = conn.prepareStatement("DELETE FROM appuntamento WHERE id_appuntamento = ?;");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante l'eleminazione dell'appuntamento!  " + e);
		}
	}

	@Override
	public List<Appuntamento> readyByUtenteID(int idCliente) {
		List<Appuntamento> appuntamentiUtente = new ArrayList<>();
		try {
			ps = conn.prepareStatement(
					" SELECT c.nome_azienda, a.id_appuntamento, a.data_appuntamento, a.descrizione, u.nome_utente"
							+ " FROM appuntamento a" + " JOIN cliente c ON c.id_cliente = a.id_cliente"
							+ " JOIN utente u ON u.id_utente = a.utente_associato" + " WHERE c.id_cliente = ?;");
			ps.setInt(1, idCliente);
			rs = ps.executeQuery();
			while (rs.next()) {
				Appuntamento a = new Appuntamento();
				a.setIdAppuntamento(rs.getInt("id_appuntamento"));
				a.setDataAppuntamento(rs.getDate("data_appuntamento"));
				a.setDescrizione(rs.getString("descrizione"));
				a.setNomeCliente(rs.getString("nome_azienda"));
				a.setNomeUtente(rs.getString("nome_utente"));
				appuntamentiUtente.add(a);
			}
			return appuntamentiUtente;
		} catch (SQLException e) {
			throw new RuntimeException("ERRORE: Qualcosa non va con il DB durante la lettura degli appuntamenti per utente!!" + e);
		}
	}

}
