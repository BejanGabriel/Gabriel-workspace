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
		if(idCliente > 0) {
			Appuntamento a = new Appuntamento(idCliente, descrizione, idUtente);
			appDao.create(a);
		}
		
		return false;
	}
	
	public Appuntamento getSingoloAppuntamento(int id) {
		if(id > 0) {
			return appDao.readByID(id);
		}
		System.out.println("Appuntamento non trovato!");
		return null;
	}
	
	public List<Appuntamento> getAppuntamenti(){
		if(!appDao.readAll().isEmpty()) {
			return appDao.readAll();
		}
		System.out.println("Lista Appuntamenti vuota!");
		return null;
	}
	
	public void eliminaAppuntamento(int id) {
		if(id > 0) {
			appDao.deleteByID(id);
			System.out.println("Appuntamento rimosso.");
			return;
		}
		System.out.println("Appuntamento non eliminato!");
	}
	
	public void modificaAppuntamento(Appuntamento appunt) {
		if(appunt != null) {
			appDao.update(appunt);
			System.out.println("Appuntamento aggiornato.");
			return;
		}
		System.out.println("Appuntamento non aggiornato!");
	}
	
}
