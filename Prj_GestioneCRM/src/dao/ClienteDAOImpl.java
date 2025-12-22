package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import utilitis.RiferimentoConnessione;

public class ClienteDAOImpl extends RiferimentoConnessione implements GenericDAO<Cliente>{
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	

	public ClienteDAOImpl() {
		
	}
	
	@Override
	public boolean create(Cliente cliente) {
		try {
			// creazione cliente
			ps = conn.prepareStatement("INSERT INTO cliente (nome_azienda, referente_azienda, categoria_merceologica, tipologia_cliente)"
					+ "VALUES (?, ?, ?, ?);"); //come assegnare un utente?
			// ===== MEMO =====
			//L'associazione avviene in un secondo momento con una join, inizialmente sarà null.
			// è vero, questa non è una join, l'assegnazione avviene in un altro momento
			// ma è sempre insert, quindi UPDATE siccome gia esiste
			// sfruttanto 'where id_cliente = ?' 
			// La Join è solo per visualizzare, non per inserire.
			// Logica che dovrà essere poi richiamata dal service, qui solo esegue QUERY.
			
			ps.setString(1, cliente.getNomeAzienda());
			ps.setString(2, cliente.getRefereneAzienda());
			ps.setString(3, cliente.getCategoriaMerceologica());
			ps.setString(4, cliente.getTipologiaCliente());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cliente readByID(int id) {
		// TODO Auto-generated method stub
		return null;
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
				cliente.setCategoriaMerceologica(rs.getString("categoria_merceologica"));
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

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
