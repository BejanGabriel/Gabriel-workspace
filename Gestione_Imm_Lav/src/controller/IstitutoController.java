package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import model.Corso;
import model.Studente;

public class IstitutoController {
// qui si gestisce la logica dell'istituto: aggiungiStudenteEdIscrivi, iscriviStudente, aggiungiCorso
	private final static String TABELLA_COMUNE = "Iscrizioni.csv";
	private CorsoController corsoCtrl = new CorsoController();
	private StudenteController studCtrl = new StudenteController();

	public IstitutoController(CorsoController corsoCtrl, StudenteController studCtrl) {
		this.corsoCtrl = corsoCtrl;
		this.studCtrl = studCtrl;
		collegaStudentiAiCorsi();
	}

	public void caricaIscrizioni() {
		File tabellaPonte = new File(TABELLA_COMUNE);
		try {
			Scanner scan = new Scanner(tabellaPonte);

			while (scan.hasNextLine()) {
				String[] separate = scan.nextLine().split(",");
				String codFiscale = separate[0];
				String codCorso = separate[1];

				Studente studente = studCtrl.findStudente(codFiscale);
				Corso corso = corsoCtrl.findCorso(codCorso);

				if (studente != null && corso != null) {
					corso.getListaStudenti().add(studente);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Qualcosa è andato storto nel DB Iscrizioni.csv");
		}
	}
	
	public void collegaStudentiAiCorsi() {

	    for (Studente s : studCtrl.getListaStudenti()) {

	        String titoloCorso = s.getCorsoIscritto();
	        if (titoloCorso == null || titoloCorso.isEmpty())
	            continue;

	        Corso corso = corsoCtrl.findCorso(titoloCorso);
	        if (corso != null) {
	            corso.getListaStudenti().add(s);
	        }
	    }
	}

// questo va scritto subito in un db, perche ho gia dati studente e il corso a cui fa riferimento
	public void aggiungiStudenteEIscrivi(String nome, String cognome, String codFiscale, String titoloCorso) {

		Studente studente = studCtrl.addStudente(nome, cognome, codFiscale, titoloCorso);
		Corso corso = corsoCtrl.findCorso(titoloCorso);

		if (studente != null && corso != null) {
//			studente.getListaCorsi().add(corso);    	da capire cosa fà
			corso.getListaStudenti().add(studente);

			scriviIscrizioneNelDB(corso.getCodCorso(), studente.getCodFiscale());
		}
	}

	private void scriviIscrizioneNelDB(String codFiscale, String codCorso) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(TABELLA_COMUNE, true))) {

			pw.println(codFiscale + "," + codCorso);

		} catch (IOException e) {
			System.out.println("Errore durante scrittura nel DB Ponte	");
		}
	}
	
	public String mostraCorsiEStudenti() {
		StringBuffer info = new StringBuffer();
		for(Corso c : corsoCtrl.getListaCorsi()) {
			info.append("\n=== Corso di " + c.getTitolo() + " ===");
			if(c.getListaStudenti().size() == 0) {
				info.append("\nNessuno studente iscritto!");
			}
			for(Studente studente : studCtrl.getListaStudenti()) {
				if(studente.getCorsoIscritto().equals(c.getTitolo())) {
					info.append("\nNome: " + studente.getNome() + "   |  Cognome: " + studente.getCognome() +
							"   |  Cod. Fiscale: " + studente.getCodFiscale());
				}
			}
			
		}
		return info.toString();
	}
	
}
