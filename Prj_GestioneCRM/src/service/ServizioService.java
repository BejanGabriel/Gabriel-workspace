package service;

import java.util.List;

import dao.ServizioDAO;
import dao.ServizioDAOImpl;
import model.Servizio;

public class ServizioService {

	private final ServizioDAO servizioDao;

	public ServizioService() {
		this.servizioDao = new ServizioDAOImpl();
	}

	public boolean aggiungiServizio(String nomeServerizio, String descrizione, double prezzo) {
		if(nomeServerizio == null || nomeServerizio.isEmpty() || nomeServerizio.matches("[^0-9]")) {
			throw new IllegalArgumentException("Il nome del servizio non può essere vuoto o nullo e non deve contenere numeri!");
		}
		Servizio newServ = new Servizio(nomeServerizio, descrizione, prezzo);
		return servizioDao.create(newServ);
	}
	
	public boolean modificaServizio(Servizio servizio) {
		if(servizio == null) {
			throw new IllegalArgumentException("Il servizio selezionato è null!");
		}
		return servizioDao.update(servizio);
	}
	
	public Servizio getServizioSingolo(int id) {
		if(id < 0) {
			throw new IllegalArgumentException("L'ID inserito non può essere negativo, hai inserito: " + id);
		}
		return servizioDao.readByID(id);
	}
	
	public List<Servizio> getAllServizi(){
		if(servizioDao.readAll() == null || servizioDao.readAll().size() == 0) {
			throw new IllegalArgumentException("La lista dei servizi è vuota / null");
		}
		return servizioDao.readAll();
	}
	
	public boolean cancellaServizio(int id) {
		if(id < 0) {
			throw new IllegalArgumentException("L'ID inserito non può essere negativo, hai inserito: " + id);
		}
		return servizioDao.deleteByID(id);
	}
	
	public List<Servizio> getServizioByClienteID(int idCliente) {
		if(idCliente < 0) throw new IllegalArgumentException("L'ID inserito non può essere negativo, hai inserito: " + idCliente);
		return servizioDao.readByClienteID(idCliente);
	}

	public boolean associaServizioCliente(int idCliente, int idServizio) {
		if(idCliente < 0 || idServizio < 0) throw new IllegalArgumentException(
				"Gli ID inserito non possono essere negativi");
		 return servizioDao.associaClienteServizio(idCliente, idServizio);
		
	}
	

}
