package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Nota;
import shortCuts.Scorciatoia;

public class NotaImpl extends Scorciatoia implements GenericDAO<Nota> {
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public boolean create(Nota nota) {
		try {
			ps = conn.prepareStatement("INSERT INTO nota (id_cliente, testo_nota, utente_registrante) values(?,?,?);");
			ps.setInt(1, nota.getIdCliente());
			ps.setString(2, nota.getTestoNota());
			ps.setInt(3, nota.getUtenteRegistrato());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Nota readByID(int id) {
		Nota n = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM nota WHERE id_nota = ?;");
			ps.setInt(1, id);
			ps.executeQuery();

			while (rs.next()) {
				n = new Nota();
				n.setIdNota(rs.getInt("id_nota"));
				n.setIdCliente(rs.getInt("id_cliente"));
				n.setTestoNota(rs.getString("testo_nota"));
				n.setDataRegistrazione(rs.getDate("data_registrazione"));
				n.setUtenteRegistrato(rs.getInt("utente_registrante"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public List<Nota> readAll() {
		List<Nota> listaNote = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT * FROM nota");
			rs = ps.executeQuery();

			while (rs.next()) {
				Nota n = new Nota();
				n.setIdNota(rs.getInt("id_nota"));
				n.setIdCliente(rs.getInt("id_cliente"));
				n.setDataRegistrazione(rs.getDate("data_registrazione"));
				n.setTestoNota(rs.getString("testo_nota"));
				n.setUtenteRegistrato(rs.getInt("utente_registrante"));

				listaNote.add(n);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaNote;
	}

	@Override
	public boolean update(Nota nota) {
		try {
			ps = conn.prepareStatement("UPDATE nota SET "
				+ "testo_nota = ?,"
				// mettiamo anche l'impossibilita per un utente di eseguire l'appuntamento,
				// allora bisogna cambiarlo.
				+ "utente_registrante = ?"
				+ "WHERE id_nota = ?;");

			ps.setString(1, nota.getTestoNota());
			ps.setInt(2, nota.getUtenteRegistrato());
			ps.setInt(3, nota.getIdNota());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByID(int id) {
		try {
			ps = conn.prepareStatement("DELETE FROM nota WHERE id_nota = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
