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



	public void aggiungiStudenteEIscrivi(String nome, String cognome, String codFiscale, String codCorso) {
		Studente studente = studCtrl.addStudente(nome, cognome, codFiscale, codCorso);
		Corso corso = corsoCtrl.findCorso(codCorso);

		if (studente != null && corso != null) {
			studente.getListaCorsi().add(corso);
			corso.getListaStudenti().add(studente);
		}
	}
}
