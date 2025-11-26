package controller;

import model.Corso;
import model.Studente;

public class IstitutoController {
// qui si gestisce la logica dell'istituto: aggiungiStudenteEdIscrivi, iscriviStudente, aggiungiCorso
	private CorsoController corsoCtrl = new CorsoController();
	private StudenteController studCtrl = new StudenteController();

	
	
	public IstitutoController(CorsoController corsoCtrl, StudenteController studCtrl) {
		super();
		this.corsoCtrl = corsoCtrl;
		this.studCtrl = studCtrl;
	}



	public void aggiungiStudenteEIscrivi(String nome, String cognome, String codFiscale, String titoloCorso) {
		Studente studente = studCtrl.addStudente(nome, cognome, codFiscale, titoloCorso);
		Corso corso = corsoCtrl.findCorso(titoloCorso);

		if (studente != null && corso != null) {
			studente.getListaCorsi().add(corso);
			corso.getListaStudenti().add(studente);
		}
	}
	
	public void studentiIscritti(String nome, String cognome, String codFiscale, String titoloCorso) {
		
		
	}
}
