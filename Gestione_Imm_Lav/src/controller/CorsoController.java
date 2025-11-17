package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Corso;

public class CorsoController {
	private static final String FILE_PATH = "CorsiDB.csv";
	private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private List<Corso> listaCorsi;

	public CorsoController() {
		this.listaCorsi = new ArrayList<>();
		caricaCorsiDaDB();
	}

	private void caricaCorsiDaDB() {
		File fileCorsi = new File(FILE_PATH);

		try {
			Scanner scan = new Scanner(fileCorsi);

			while (scan.hasNextLine()) {
				String riga = scan.nextLine();
				String[] separate = riga.split(",");
				String titolo = separate[0];
				String codCorso = separate[1];
				Date data = DF.parse(separate[2]);

				Corso corso = new Corso(titolo, codCorso, data);
				this.listaCorsi.add(corso);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Non ci sono corsi nel DB!!");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean addCorso(String titolo, String codCorso) {
		if (!titolo.equals(null) && !codCorso.equals(null)) {
			Corso nuovo = new Corso(titolo, codCorso, new Date());

			for (Corso corsoInLista : listaCorsi) {
				if (corsoInLista.compareTo(nuovo) == 0) {
					System.out.println("Il corso è gia presente nella lista");
					return false;
				}
			}
			listaCorsi.add(nuovo);
			scriviNelDB();
			System.out.println("Corso aggiunto correttamente");
		}
		return false;
	}

	public boolean removeCorso(String codCorso) {
		if (!codCorso.equals(null)) {
			boolean rimosso = listaCorsi.removeIf(c -> c.getCodCorso().equals(codCorso));
			if (rimosso) {
				System.out.println("Corso rimosso correttamente");
				System.out.println("Riscrittura DB in corso...");
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
			for (Corso corso : listaCorsi) {
				pw.println(corso.getTitolo() + "," + corso.getCodCorso() + "," + DF.format(corso.getDataCreazione()));
			}
		} catch (IOException e) {
			System.out.println("Errore durante scrittura nel DB");
		}
	}

	public String visualizzaCorsi() {
		StringBuffer info = new StringBuffer();
		info.append("==== Lista Corsi ====");
		for (Corso corso : listaCorsi) {
			info.append("\nTitolo: " + corso.getTitolo() + "  |  Codice Corso: " + corso.getCodCorso() + "  |  Creato il: " + DF.format(corso.getDataCreazione()));
		}
		return info.toString();
	}

}
