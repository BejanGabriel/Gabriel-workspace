package service;

import java.util.List;

import dao.AppuntamentoDAO;
import dao.AppuntamentoDAOImpl;
import model.Appuntamento;

public class AppuntamentoService {

	private final AppuntamentoDAO appDao;

	public AppuntamentoService() {
		this.appDao = new AppuntamentoDAOImpl();
	}
	
	public boolean creaAppuntamento(int idCliente, String descrizione, int idUtente) {
		if(idCliente < 0) {
			throw new IllegalArgumentException("Errore: L'ID del cliente non è valido!");
		}
		Appuntamento a = new Appuntamento(idCliente, descrizione, idUtente);
		return appDao.create(a);
		
	}
	
	public Appuntamento getSingoloAppuntamento(int id) {
		if(id < 0) {
			throw new IllegalArgumentException("L'ID inserito non è valido!");
		}
		Appuntamento trovato = appDao.readByID(id);
		if(trovato == null) {
			throw new IllegalStateException("Errore: L'appuntamento cercato non è presente nel database!");
		}else {
			return trovato;
		}
	}
	
	public List<Appuntamento> getAppuntamenti(){
			return appDao.readAll();
	}
	
	public boolean eliminaAppuntamento(int id) {
		if(id < 0) {
			throw new IllegalArgumentException("Errore: L'ID dell'appuntamento da eliminare non è valido!");
		}
		boolean eliminato = appDao.deleteByID(id);
		if(!eliminato) {
			throw new IllegalStateException("Errore: Non è stato trovato nessun appuntamento da eliminare");
		}else {
			return eliminato;
		}
	}
	
	public boolean modificaAppuntamento(Appuntamento appunt) {
		if(appunt == null) {
			throw new IllegalArgumentException("Errore: L'appuntamento selezionato risulta essere inesistente!");
		}
		boolean modificato = appDao.update(appunt);
		if(!modificato) {
			throw new IllegalStateException("Errore: Non è stato possibile modificare l'appuntamento selezionato");
		}else {
			return modificato;
		}
	}

	public List<Appuntamento> getAppuntamentiCliente(int idCliente) {
		if(idCliente < 0) throw new IllegalArgumentException("L'id cliente inserito non può essere minore di 0! Hai inserito: " + idCliente);
		return appDao.readyByUtenteID(idCliente);
	}
	
}
