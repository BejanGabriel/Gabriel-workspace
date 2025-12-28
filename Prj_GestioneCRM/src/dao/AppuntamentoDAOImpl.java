package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Appuntamento;
import utilitis.RiferimentoConnessione;

public class AppuntamentoDAOImpl extends RiferimentoConnessione implements AppuntamentoDAO{

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
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Appuntamento readByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appuntamento> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Appuntamento entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
