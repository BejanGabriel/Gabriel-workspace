package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Studente;

public class StudenteController {
	private static final String FILE_PATH = "StudentiDB.csv";
	private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private List<Studente> listaStudenti;

	public StudenteController() {
		this.listaStudenti = new ArrayList<>();
		caricaStudentiDaDB();
	}

	private void caricaStudentiDaDB() {
		File fileStudenti = new File(FILE_PATH);

		try {
			Scanner scan = new Scanner(fileStudenti);

			while (scan.hasNextLine()) {
				String riga = scan.nextLine();
				String[] separate = riga.split(",");
				String nome = separate[0];
				String cognome = separate[1];
				String codFiscale = separate[2];
				String corsoIscritto = separate[3];

				Studente studente = new Studente(nome, cognome, codFiscale, corsoIscritto);
				this.listaStudenti.add(studente);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Non ci sono corsi nel DB!!");
		} 
	}

	public Studente addStudente(String nome, String cognome, String codFiscale, String corsoIscritto) {
		if (!codFiscale.equals(null) && !corsoIscritto.equals(null)) {
			Studente nuovo = new Studente(nome, cognome, codFiscale, corsoIscritto);

			for (Studente studentiInLista : listaStudenti) {
				if (studentiInLista.compareTo(nuovo) == 0) {
					System.out.println("Il corso è gia presente nella lista");
					return null;
				}
			}
			listaStudenti.add(nuovo);
			scriviNelDB();
			System.out.println("Studente aggiunto correttamente");
			System.out.println("Aggiornamento DB in corso...");
			return nuovo;
		}
		return null;
	}

	public boolean removeStudente(String codFiscale) {
		if (!codFiscale.equals(null)) {
			boolean rimosso = listaStudenti.removeIf(c -> c.getCodFiscale().equals(codFiscale));
			if (rimosso) {
				System.out.println("Corso rimosso correttamente");
				System.out.println("Aggiornamento DB in corso...");
				scriviNelDB();
				return true;
			} else {
				System.out.println("Il codice inserito non esiste");
			}
		}
		return false;
	}

	// siccome il metodo removeCorso rimuoverebbe il parametro SOLO dalla List e non
	// anche
	// dal file CSV, si decide di riscrivere il CSV aggiornandolo

	public void scriviNelDB() {
		try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, false))) {
			for (Studente studente : listaStudenti) {
				pw.println(studente.getNome() + "," + studente.getCognome() + "," + studente.getCodFiscale() + "," + studente.getCorsoIscritto());
			}
		} catch (IOException e) {
			System.out.println("Errore durante scrittura nel DB");
		}
	}

	public String visualizzaStudenti() {
		StringBuffer info = new StringBuffer();
		info.append("==== Lista Studenti ====");
		if(listaStudenti.size() == 0) {
			info.append("\nNessun Studente presente");
		}
		for (Studente studente : listaStudenti) {
			info.append("\nNome: " + studente.getNome() + "  |  Cognome: " + studente.getCognome() +
					"  |  Codice Fiscale: " + studente.getCodFiscale() + "   |   Iscritto a: \n" + studente.getListaCorsi());
		}
		return info.toString();
	}


}
