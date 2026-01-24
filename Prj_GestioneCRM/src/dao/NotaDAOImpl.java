package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Nota;
import shortCuts.Scorciatoia;

public class NotaDAOImpl extends Scorciatoia implements NotaDAO {
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public boolean create(Nota nota) {
		try {
			ps = conn.prepareStatement("INSERT INTO note_cliente (id_cliente, testo_nota, utente_registrante) values(?,?,?);");
			ps.setInt(1, nota.getIdCliente());
			ps.setString(2, nota.getTestoNota());
			ps.setInt(3, nota.getUtenteRegistrato());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la creazione della Nota! ", e);
		}
	}

	@Override
	public Nota readByID(int id) {
		Nota n = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM note_cliente WHERE id_nota = ?;");
			ps.setInt(1, id);
			ps.executeQuery();

			while (rs.next()) {
				n = new Nota();
				n.setIdNota(rs.getInt("id_nota"));
				n.setIdCliente(rs.getInt("id_cliente"));
				n.setTestoNota(rs.getString("testo_nota"));
				n.setDataRegistrazione(rs.getDate("data_registrazione"));
				n.setUtenteRegistrato(rs.getInt("utente_registrante"));

				return n;
			}
			//nota non trovata
			return null;
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la ricerca della singola nota! ", e);
		}
	}

	@Override
	public List<Nota> readAll() {
		List<Nota> listaNote = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT * FROM note_cliente");
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
			
			return listaNote;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la lettura delle note!", e);
		}
	}

	@Override
	public boolean update(Nota nota) {
		try {
			ps = conn.prepareStatement("UPDATE note_cliente SET " + "testo_nota = ?,"
			// mettiamo anche l'impossibilita per un utente di eseguire l'appuntamento,
			// allora bisogna cambiarlo.
					+ "utente_registrante = ?" + "WHERE id_nota = ?;");

			ps.setString(1, nota.getTestoNota());
			ps.setInt(2, nota.getUtenteRegistrato());
			ps.setInt(3, nota.getIdNota());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante l'aggiornamento della nota!", e);
		}
	}

	@Override
	public boolean deleteByID(int id) {
		try {
			ps = conn.prepareStatement("DELETE FROM note_cliente WHERE id_nota = ?;");
			ps.setInt(1, id);
			
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante l'eliminazione della nota!", e);
		}
	}

	@Override
	public List<Nota> readByClienteID(int idCliente) {
		List<Nota> listaNotaCliente = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT n.id_nota, n.testo_nota descrizione, n.data_registrazione `data`, u.nome_utente utenteRegistrante FROM note_cliente n "
					+ "JOIN utente u ON n.utente_registrante = u.id_utente "
					+ "WHERE id_cliente = ?;");
			ps.setInt(1, idCliente);
			rs = ps.executeQuery();
			while(rs.next()) {
				Nota n = new Nota();
				n.setIdNota(rs.getInt("id_nota"));
				n.setDataRegistrazione(rs.getDate("data"));
				n.setTestoNota(rs.getString("descrizione"));
				n.setNomeUtente(rs.getString("utenteRegistrante"));
				listaNotaCliente.add(n);
			}
			
			return listaNotaCliente;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la lettura delle note per cliente ID! ", e);
		}
	}

}
