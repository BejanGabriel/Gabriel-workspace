package gestione_Traffico_Semaforico;


public class Semaforo {
	private StatoSemaforo statoCorrente = StatoSemaforo.ROSSO;

	public StatoSemaforo getStatoCorrente() {
		return statoCorrente;
	}

	public StatoSemaforo cambiaStato() {
		return statoCorrente = statoCorrente.prossimoStato();
	}

	public boolean verificaPassaggio(TipoVeicolo veicolo) {
		if (veicolo.getPriorita() == 5) {
			return true;
		} else if (getStatoCorrente() == StatoSemaforo.VERDE) {
			return true;
		}
		return false;
	}
	
	public String stampaStato() {
		return "Stato: " + statoCorrente + "(" + statoCorrente.getDurata() + " secondi) - " + statoCorrente.getDescrizione();
	}
}
