package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.CategoriaMerceologica;
import model.Cliente;
import shortCuts.Scorciatoia;

public class ClienteDAOImpl extends Scorciatoia implements ClienteDAO{
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	

	public ClienteDAOImpl() {
		
	}
	
	@Override
	public boolean create(Cliente cliente) {
		try {
			// creazione cliente
			ps = conn.prepareStatement("INSERT INTO cliente (nome_azienda, referente_azienda, categoria_merceologica, tipologia_cliente, utente_associato)"
					+ "VALUES (?, ?, ?, ?, ?);"); //come assegnare un utente?
			// ===== MEMO =====
			//L'associazione avviene in un secondo momento con una join, inizialmente sarà null.
			// NO, questa non è una join, l'assegnazione avviene in un altro momento
			// ma è sempre insert, quindi UPDATE siccome gia esiste
			// sfruttando 'where id_cliente = ?' 
			// La Join è solo per visualizzare, non per inserire.
			// Logica che dovrà essere poi richiamata dal service, qui esegue solo la QUERY.
			
			ps.setString(1, cliente.getNomeAzienda());
			ps.setString(2, cliente.getRefereneAzienda());
			ps.setString(3, cliente.getCategoriaMerceologica().getNome());
			ps.setString(4, cliente.getTipologiaCliente());
			ps.setInt(5, cliente.getUtenteAssociato());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cliente readByID(int id) {
		Cliente c = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				c = new Cliente();
				c.setIdCliente(rs.getInt("id_cliente"));
				c.setNomeAzienda(rs.getString("nome_azienda"));
				c.setRefereneAzienda(rs.getString("referente_azienda"));
				c.setCategoriaMerceologica(CategoriaMerceologica.valueOf(rs.getString("categoria_merceologica").toUpperCase()));
				c.setTipologiaCliente(rs.getString("tipologia_cliente"));
				c.setUtenteAssociato(rs.getInt("utente_associato"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Cliente> readAll() {
		List<Cliente> allClienti = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT * FROM cliente;");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("id_cliente"));
				cliente.setNomeAzienda(rs.getString("nome_azienda"));
				cliente.setCategoriaMerceologica(CategoriaMerceologica.valueOf(rs.getString("categoria_merceologica").toUpperCase()));
				cliente.setRefereneAzienda(rs.getString("referente_azienda"));
				cliente.setTipologiaCliente(rs.getString("tipologia_cliente"));
				cliente.setUtenteAssociato(rs.getInt("utente_associato"));
				
				allClienti.add(cliente);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return allClienti;
	}

	@Override
	public boolean update(Cliente cliente) {
		try {
			ps = conn.prepareStatement("UPDATE cliente SET "
					+ "nome_azienda = ?,"
					+ "referente_azienda = ?,"
					+ "categoria_merceologica = ?,"
					+ "tipologia_cliente = ?,"
					+ "utente_associato = ? "
					+ "WHERE id_cliente = ?;");
			ps.setString(1, cliente.getNomeAzienda());
			ps.setString(2, cliente.getRefereneAzienda());
			ps.setString(3, cliente.getCategoriaMerceologica().getNome());
			ps.setString(4, cliente.getTipologiaCliente());
			ps.setInt(5, cliente.getUtenteAssociato());
			ps.setInt(6, cliente.getIdCliente());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByID(int id) {
		try {
			ps = conn.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	// ATTUALMENTE NON SERVE PIù --- RIMUOVERE SUCCESSIVAMENTE DAL CODICE
	@Override
	public boolean assegnazioneByID(int idSet, int idWhere) {
		try {
			ps = conn.prepareStatement("UPDATE cliente SET utente_associato = ? WHERE id_cliente = ?");
			ps.setInt(1, idSet);
			ps.setInt(2, idWhere);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
}
