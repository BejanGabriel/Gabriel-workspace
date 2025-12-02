package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Corso implements Comparable<Corso>{
	private static int CONTATORE = 0;
	private Integer id;
	private String titoloCorso;
	private String codCorso;
	private String aulaCorso;
	//private Date dataCreazione;
	private List<Studente> listaStudenti;

	public Corso(Integer id, String titoloCorso, String codCorso, String aulaCorso) {
		this.id = CONTATORE++;
		this.titoloCorso = titoloCorso;
		this.codCorso = codCorso;
		this.aulaCorso = aulaCorso;
		//this.dataCreazione = dataCreazione;
		listaStudenti = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitoloCorso() {
		return titoloCorso;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public String getAulaCorso() {
		return aulaCorso;
	}

	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}

	@Override
	public int compareTo(Corso altro) {
		return this.codCorso.compareTo(altro.getCodCorso()); // confronto codici dei corsi	
	}

	
	

}
