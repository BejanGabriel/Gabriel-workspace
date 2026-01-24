package service;

import java.util.List;

import dao.NotaDAO;
import dao.NotaDAOImpl;
import model.Nota;

public class NotaService {
	
	private NotaDAO notaDao;

	public NotaService() {
		this.notaDao = new NotaDAOImpl();
	}
	
	public boolean creaNota(int idCliente, String testoNota, int utenteRegistrante){
		if(idCliente < 0) throw new IllegalArgumentException("L'id cliente inserito non è valido!");
		Nota nuovo = new Nota(idCliente, testoNota, utenteRegistrante);
		boolean creato = notaDao.create(nuovo);
		if(!creato) {
			throw new IllegalStateException("La nota non è stata creata");
		}
		return creato;
	}
	
	public Nota getSingolaNota(int idNota) {
		if(idNota < 0) throw new IllegalArgumentException("L'id nota inserito non è valido!");
		Nota trovata = notaDao.readByID(idNota);
		if(trovata == null) {
			throw new IllegalStateException("Non è stata trovata alcuna nota con questo ID");
		}
		return trovata;
	}
	
	public List<Nota> getNoteCliente(int idCliente) {
		if(idCliente < 0) throw new IllegalArgumentException("L'id cliente inserito non è valido!");
		return notaDao.readByClienteID(idCliente);
	}
	
	public List<Nota> getAllNota(){
		if(notaDao.readAll().size() == 0) throw new IllegalArgumentException("La lista Nota è vuota!");
		return notaDao.readAll();
	}
	
	public boolean eliminaNota(int idNota) {
		if(idNota < 0) throw new IllegalArgumentException("L'id nota inserito non può essere minore di 0! Hai inserito: " + idNota);
		boolean eliminato = notaDao.deleteByID(idNota);
		if(!eliminato) {
			throw new IllegalStateException("La nota non sembra esiste nel DB");
		}
		return eliminato;
	}
	
	public boolean modificaNota(Nota nota) {
		if(nota == null) throw new IllegalArgumentException("La nota selezionata è null!");
		boolean modificata = notaDao.update(nota);
		if(!modificata) {
			throw new IllegalStateException("La nota non è stata modificata perche inesistente!");
		}
		return modificata;
	}
	
	
}
