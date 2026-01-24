package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CategoriaMerceologica;
import model.Cliente;
import model.TipologiaCliente;
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
					+ "VALUES (?, ?, ?, ?, ?);"); 
			
			ps.setString(1, cliente.getNomeAzienda());
			ps.setString(2, cliente.getRefereneAzienda());
			ps.setString(3, cliente.getCategoriaMerceologica().getNome());
			ps.setString(4, cliente.getTipologiaCliente().getNome());
			ps.setInt(5, cliente.getUtenteAssociato());
			int rows = ps.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la creazione cliente", e);
		}
	}

	@Override
	public Cliente readByID(int id) {
		
		try {
			ps = conn.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("id_cliente"));
				c.setNomeAzienda(rs.getString("nome_azienda"));
				c.setRefereneAzienda(rs.getString("referente_azienda"));
				c.setCategoriaMerceologica(CategoriaMerceologica.valueOf(rs.getString("categoria_merceologica").toUpperCase()));
				c.setTipologiaCliente(TipologiaCliente.valueOf(rs.getString("tipologia_cliente").toUpperCase().replace(" ", "")));
				c.setUtenteAssociato(rs.getInt("utente_associato"));
				
				return c;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la ricerca per ID del Cliente!", e);
		}
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
				cliente.setTipologiaCliente(TipologiaCliente.valueOf(rs.getString("tipologia_cliente").toUpperCase().replace(" ", "")));
				cliente.setUtenteAssociato(rs.getInt("utente_associato"));
				
				allClienti.add(cliente);
			}
			
			return allClienti;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante la visualizzazione della lista clienti", e);
		}
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
			ps.setString(4, cliente.getTipologiaCliente().getNome());
			ps.setInt(5, cliente.getUtenteAssociato());
			ps.setInt(6, cliente.getIdCliente());
			int rows = ps.executeUpdate();
			return rows > 0;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante l'aggiornamento del Cliente", e);
		}
	}

	@Override
	public boolean deleteByID(int id) {
		try {
			ps = conn.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?;");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante l'eliminazione del Cliente", e);
		}
	}

	

	@Override
	public List<Cliente> readByCategoria(String categoria) {
		List<Cliente> clientiCategoria = new ArrayList<>();
		try {
			ps= conn.prepareStatement("SELECT * FROM cliente WHERE categoria_merceologica = ?");
			ps.setString(1, categoria);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("id_cliente"));
				c.setNomeAzienda(rs.getString("nome_azienda"));
				c.setRefereneAzienda(rs.getString("referente_azienda"));
				c.setCategoriaMerceologica(CategoriaMerceologica.valueOf(rs.getString("categoria_merceologica").toUpperCase()));
				c.setTipologiaCliente(TipologiaCliente.valueOf(rs.getString("tipologia_cliente").toUpperCase().replace(" ", "")));
				c.setUtenteAssociato(rs.getInt("utente_associato"));
				
				clientiCategoria.add(c);
			}
			return clientiCategoria;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante lettura clienti per categoria!", e);
		}
	}

	@Override
	public List<Cliente> readByTipologia(String tipologia) {
		List<Cliente> clientiTipologia = new ArrayList<>();
		try {
			ps= conn.prepareStatement("SELECT * FROM cliente WHERE tipologia_cliente = ?");
			ps.setString(1, tipologia);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("id_cliente"));
				c.setNomeAzienda(rs.getString("nome_azienda"));
				c.setRefereneAzienda(rs.getString("referente_azienda"));
				c.setCategoriaMerceologica(CategoriaMerceologica.valueOf(rs.getString("categoria_merceologica").toUpperCase()));
				c.setTipologiaCliente(TipologiaCliente.valueOf(rs.getString("tipologia_cliente").toUpperCase().replace(" ", "")));
				c.setUtenteAssociato(rs.getInt("utente_associato"));
				
				clientiTipologia.add(c);
			}
			return clientiTipologia;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante lettura clienti per tipologia!", e);
		}
		
	}
	

	@Override
	public List<Cliente> readByUtente(int idUtente) {
		List<Cliente> clientiUtente = new ArrayList<>();
		try {
			ps= conn.prepareStatement("SELECT * FROM cliente WHERE utente_associato = ?");
			ps.setInt(1, idUtente);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("id_cliente"));
				c.setNomeAzienda(rs.getString("nome_azienda"));
				c.setRefereneAzienda(rs.getString("referente_azienda"));
				c.setCategoriaMerceologica(CategoriaMerceologica.valueOf(rs.getString("categoria_merceologica").toUpperCase()));
				c.setTipologiaCliente(TipologiaCliente.valueOf(rs.getString("tipologia_cliente").toUpperCase().replace(" ", "")));
				c.setUtenteAssociato(rs.getInt("utente_associato"));
				
				clientiUtente.add(c);
			}
			return clientiUtente;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore nel DB durante lettura clienti per ID-Utente!", e);
		}
	}
	
}
