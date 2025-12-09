package gestione_Traffico_Semaforico;

public enum StatoSemaforo {
	
	ROSSO(30),
	GIALLO(5),
	VERDE(45);
	
	private int durata;

	private StatoSemaforo(int durata) {
		this.durata = durata;
	}

	public int getDurata() {
		return durata;
	}
	
	
	
}
