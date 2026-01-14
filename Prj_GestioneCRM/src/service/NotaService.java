package service;

import java.util.List;

import dao.NotaDAO;
import dao.NotaImpl;
import model.Nota;

public class NotaService {
	
	private NotaDAO notaDao;

	public NotaService() {
		this.notaDao = new NotaImpl();
	}
	
	public boolean creaNota(int idCliente, String testoNota, int utenteRegistrante){
		if(idCliente < 0) throw new IllegalArgumentException("L'id cliente inserito non può essere minore di 0! Hai inserito: " + idCliente);
		Nota nuovo = new Nota(idCliente, testoNota, utenteRegistrante);
		return notaDao.create(nuovo);
	}
	
	public Nota getSingolaNota(int idNota) {
		if(idNota < 0) throw new IllegalArgumentException("L'id nota inserito non può essere minore di 0! Hai inserito: " + idNota);
		return notaDao.readByID(idNota);
	}
	
	public List<Nota> getNoteCliente(int idCliente) {
		if(idCliente < 0) throw new IllegalArgumentException("L'id cliente inserito non può essere minore di 0! Hai inserito: " + idCliente);
		return notaDao.readByClienteID(idCliente);
	}
	
	public List<Nota> getAllNota(){
		if(notaDao.readAll().size() == 0) throw new IllegalArgumentException("La lista Nota è vuota!");
		return notaDao.readAll();
	}
	
	public boolean eliminaNota(int idNota) {
		if(idNota < 0) throw new IllegalArgumentException("L'id nota inserito non può essere minore di 0! Hai inserito: " + idNota);
		return notaDao.deleteByID(idNota);
	}
	
	public boolean modificaNota(Nota nota) {
		if(nota == null) throw new IllegalArgumentException("La nota selezionata è null!");
		return notaDao.update(nota);
	}
	
	
}
