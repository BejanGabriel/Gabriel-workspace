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
import model.Studente;

public class Databases {
	private static final String CORSI_PATH = "CorsiDB.csv";
	private static final String STUDENTI_PATH = "StudentiDB.csv";


	public List<Corso> caricaListaCorsi() {
		List<Corso> listaCorsi = new ArrayList<>();
		File file = new File(CORSI_PATH);
		if (!file.exists()) {
			return listaCorsi;
		}
		
		try (Scanner scan = new Scanner(file)) {
			while(scan.hasNext()) {
				String[] riga = scan.nextLine().split(",");
				int id = Integer.parseInt(riga[0]);
				String titoloCorso = riga[1];
				String codCorso = riga[2];
				String aula = riga[3];
				Corso nuovo = new Corso(id, titoloCorso, codCorso, aula);
				nuovo.setId(id);
				listaCorsi.add(nuovo);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaCorsi;
	}
	
	public List<Studente> caricaListaStudenti(){
		List<Studente> listaStudenti = new ArrayList<>();
		File file = new File(STUDENTI_PATH);
		if(!file.exists()) {
			return listaStudenti; 
		}
		
		try(Scanner scan = new Scanner(file)){
			while(scan.hasNext()) {
			String[] riga = scan.nextLine().split(",");
			int id = Integer.parseInt(riga[0]);
			String nome = riga[1];
			String cognome = riga[2];
			String codFiscale = riga[3];
			String codCorsoIscritto = riga[4];
			
			Studente nuovo = new Studente(id, nome, cognome, codFiscale, codCorsoIscritto);
			nuovo.setId(id);
			listaStudenti.add(nuovo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaStudenti;
	}
	
	public void salvaListaCorsi(List<Corso> listaCorsi) {
		try(PrintWriter pw = new PrintWriter(new FileWriter(CORSI_PATH, false))){
			for(Corso c : listaCorsi) {
				pw.println(c.getId() + "," + c.getTitoloCorso() + "," + c.getCodCorso() + "," + c.getAulaCorso());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvaListaStudenti(List<Studente> listaStudenti) {
		try(PrintWriter pw = new PrintWriter(new FileWriter(STUDENTI_PATH, false))){
			for(Studente s : listaStudenti) {
				pw.println(s.getId() + "," + s.getNome() + "," + s.getCognome() + "," + s.getCodFiscale() + "," + s.getCodCorsoIscritto());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
