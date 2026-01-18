package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Nota;
import model.Servizio;
import shortCuts.Scorciatoia;

public class ServizioImpl extends Scorciatoia implements GenericDAO<Servizio> {
	private static PreparedStatement ps;
	private static ResultSet rs;

	@Override
	public boolean create(Servizio servizio) {
		try {
			ps = conn.prepareStatement(
					"INSERT INTO servizio_consulenza (nome_servizio, descrizione, prezzo) VALUES (?,?,?);");
			ps.setString(1, servizio.getNomeServizio());
			ps.setString(2, servizio.getDescrizione());
			ps.setDouble(3, servizio.getPrezzo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Servizio readByID(int id) {
		Servizio servizio = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM servizio_consulenza WHERE id_servizio = ?;");
			ps.setInt(1, id);
			ps.executeQuery();
			while (rs.next()) {
				servizio = new Servizio();
				servizio.setIdServizio(rs.getInt("id_servizio"));
				servizio.setNomeServizio(rs.getString("nome_servizio"));
				servizio.setDescrizione(rs.getString("descrizione"));
				servizio.setPrezzo(rs.getDouble("prezzo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Servizio> readAll() {
		List<Servizio> listaServizi = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT * FROM servizio_consulenza");
			rs = ps.executeQuery();
			while (rs.next()) {
				Servizio s = new Servizio();
				s.setIdServizio(rs.getInt("id_servizio"));
				s.setNomeServizio(rs.getString("nome_servizio"));
				s.setDescrizione(rs.getString("descrizione"));
				s.setPrezzo(rs.getDouble("prezzo"));
				listaServizi.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaServizi;
	}

	@Override
	public boolean update(Servizio servizio) {
		try {
			ps = conn.prepareStatement("UPDATE servizio_consulenza SET " + "nome_servizio = ?," + "descrizione = ?,"
					+ "prezzo = ?" + "WHERE id_servizio = ?;");
			ps.setString(1, servizio.getNomeServizio());
			ps.setString(2, servizio.getDescrizione());
			ps.setDouble(3, servizio.getPrezzo());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByID(int id) {
		try {
			ps = conn.prepareStatement("DELETE FROM servizio_consulenza WHERE id_servizio");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Servizio> readByClienteID(int idCliente) {
		List<Servizio> serviziCliente = new ArrayList<Servizio>();
		try {
			ps = conn.prepareStatement("SELECT nome_servizio, descrizione, prezzo, nome_azienda "
					+ "FROM servizio_consulenza s"
					+ "JOIN servizio_cliente sc ON sc.id_servizio =  s.id_servizio"
					+ "JOIN cliente c ON c.id_cliente = sc.id_cliente"
					+ "WHERE id_cliente = ?;");
			ps.setInt(1, idCliente);
			rs = ps.executeQuery();
			while(rs.next()) {
				Servizio s = new Servizio();
				s.setNomeServizio(rs.getString("nome_servizio"));
				s.setDescrizione(rs.getString("descrizione"));
				s.setPrezzo(rs.getDouble("prezzo"));
				s.setNomeCliente(rs.getString("nome_azienda"));
				serviziCliente.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serviziCliente;
	}
	
	public boolean associaClienteServizio(int idCliente, int idServizio) {
		try {
			ps = conn.prepareStatement("INSERT INTO servizio_cliente (id_cliente, id_servizio) VALUES "
					+ "id_cliente = ?, "
					+ "id_servizio = ?;");
			ps.setInt(1, idCliente);
			ps.setInt(2, idServizio);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
