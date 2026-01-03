package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Servizio;
import shortCuts.Scorciatoia;

public class ServizioImpl extends Scorciatoia implements GenericDAO<Servizio>{
	private static PreparedStatement ps;
	private static ResultSet rs;

	@Override
	public boolean create(Servizio servizio) {
		try {
			ps = conn.prepareStatement("INSERT INTO servizio (nome_servizio, descrizione, prezzo) VALUES (?,?,?,?);");
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
			ps = conn.prepareStatement("SELECT * FROM servizio WHERE id_servizio = ?;");
			ps.setInt(1, id);
			ps.executeQuery();
			while (rs.next()){
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
			ps = conn.prepareStatement("SELECT * FROM servizio");
			ps.executeQuery();
			while(rs.next()) {
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
			ps = conn.prepareStatement("UPDATE servizio SET "
					+ "nome_servizio = ?,"
					+ "descrizione = ?,"
					+ "prezzo = ?"
					+ "WHERE id_servizio = ?;");
			ps.setString(1, servizio.getNomeServizio());
			ps.setString(2, servizio.getDescrizione());
			ps.setDouble(3, servizio.getPrezzo());
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByID(int id) {
		try {
			ps = conn.prepareStatement("DELETE FROM servizio WHERE id_servizio");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
