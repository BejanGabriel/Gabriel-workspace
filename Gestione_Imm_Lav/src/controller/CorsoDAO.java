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

/*Lo scopo di questa classe è unicamente la gestion della logia legata al Database Corsi*/

public class CorsoDAO {
	private static final String FILE_PATH = "CorsiDB.csv";
	private List<Corso> listaCorsi;

	public CorsoDAO() {
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

	public void addCorso(String nomeCorso, String codCorso) {
		Corso corso = new Corso(nomeCorso, codCorso);
		
		try {
		FileWriter fw = new FileWriter(FILE_PATH, true);
		PrintWriter pw = new PrintWriter(fw);	
		
		pw.print("\n" + corso.getTitolo() + "," + corso.getCodCorso());
		pw.close();
		fw.close();
		
		listaCorsi.add(corso);
		
		System.out.println("Corso aggiunto correttamente");
		}catch (IOException e) {
			System.out.println("Corso non aggiunto");
		}
	}

	public boolean removeCorso(String codCorso) {
		return listaCorsi.removeIf(c -> c.getCodCorso().equals(codCorso));
	}

	public List<Corso> visualizzaCorsi() {
		caricaCorsiDaDB();
		return listaCorsi;
	}
	
}