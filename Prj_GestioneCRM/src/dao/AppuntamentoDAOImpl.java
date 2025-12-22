package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Appuntamento;
import utilitis.RiferimentoConnessione;

public class AppuntamentoDAOImpl extends RiferimentoConnessione implements GenericDAO<Appuntamento> {

	private PreparedStatement ps;
	private ResultSet rs;

	public AppuntamentoDAOImpl() {
	}

	@Override
	public boolean create(Appuntamento entity) {
		// id_appuntament(col-1) è gia automaticamente gesti da mysql.
		// appuntamento ha 2 foreign key, id_cliente(col-2) e utente_associato(col-5)
		try {
			ps = conn.prepareStatement(
					"INSERTI INTO appuntamento (id_cliente, data_appuntamento, descrizione, utente_associato)"
							+ " value (?,?);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
