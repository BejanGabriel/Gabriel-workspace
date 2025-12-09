package gestione_Traffico_Semaforico;

public enum StatoSemaforo {

	ROSSO(30) {
		@Override
		public StatoSemaforo prossimoStato() {
			return VERDE;
		}

		@Override
		public boolean puoPassare() {
			return false;
		}

		@Override
		public String getDescrizione() {
			return "STOP! Non passare";
		}
	}, 
	GIALLO(5) {
		@Override
		public StatoSemaforo prossimoStato() {
			return ROSSO;
		}

		@Override
		public boolean puoPassare() {
			return false;
		}

		@Override
		public String getDescrizione() {
			return "ATTENZIONE! Rallenta";
		}
	}, 
	VERDE(45) {
		@Override
		public StatoSemaforo prossimoStato() {
			return ROSSO;
		}

		@Override
		public boolean puoPassare() {
			return true;
		}

		@Override
		public String getDescrizione() {
			return "VIA LIBERA! Puoi passare";
		}
	};

	private final int durata;

	StatoSemaforo(int durata) {
		this.durata = durata;
	}

	public int getDurata() {
		return durata;
	}
	
	public abstract StatoSemaforo prossimoStato();
	public abstract boolean puoPassare();
	public abstract String getDescrizione();

}
