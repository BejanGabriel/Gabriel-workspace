package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Corso;

public class CorsoController {
	private static final String FILE_PATH = "CorsiDB.csv";
	private List<Corso> listaCorsi;
	
	public CorsoController() {
		caricaCorsiDaDB();
		this.listaCorsi = new ArrayList<>();
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

				Corso corso = new Corso(titolo, codCorso);
				this.listaCorsi.add(corso);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Non ci sono corsi nel DB!!");
		}
	}
	
	public boolean addCorso(String titolo, String codCorso) {
		if(!titolo.equals(null) && !codCorso.equals(null)) {
			Corso nuovo = new Corso(titolo, codCorso);
			if(listaCorsi.size() == 0) {
				listaCorsi.add(nuovo);
				return true;
			}else {
				for (Corso corsoInLista : listaCorsi) {
					if(corsoInLista.compareTo(nuovo) == 0) {
						System.out.println("Il corso è gia presente nella lista");
						return false;
					}else {
						listaCorsi.add(nuovo);
						return true;
					}
				}
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true));
				pw.print("\n" + nuovo.getTitolo() + "," + nuovo.getCodCorso());
				pw.close();
			} catch (IOException e) {
				System.out.println("Errore durante scrittura nel DB");
				return false;
			}
			System.out.println("Corso aggiunto correttamente nel Database");
			return true;
		}
		return false;
	}


	public boolean removeCorso(String codCorso) {
		if(!codCorso.equals(null)) {
		return listaCorsi.removeIf(c -> c.getCodCorso().equals(codCorso));
		}else {
			System.out.println("Codice Corso non valido!!");
			return false;
		}
	}
	
	//siccome il metodo removeCorso rimuoverebbe il parametro solo dalla List e non dal file CSV, si decide di riscrivere il CSV aggiornandolo
	
	public static scriviNelDB() {
		try(PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))){
			for(Corso c : )
		}
	}

	public List<Corso> visualizzaCorsi() {
		return new ArrayList<>(listaCorsi);
	}
	
}
