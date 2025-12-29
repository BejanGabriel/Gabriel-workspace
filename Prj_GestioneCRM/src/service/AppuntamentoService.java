package service;

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
	
	
}
