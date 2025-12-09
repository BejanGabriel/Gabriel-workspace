package gestione_Traffico_Semaforico;

public enum TipoVeicolo {
	AUTO(2) {
		@Override
		public boolean puoPassareConRosso() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	MOTO(2) {
		@Override
		public boolean puoPassareConRosso() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	AUTOBUS(3) {
		@Override
		public boolean puoPassareConRosso() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	BICICLETA(1) {
		@Override
		public boolean puoPassareConRosso() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	AMBULANZA(5) {
		@Override
		public boolean puoPassareConRosso() {
			// TODO Auto-generated method stub
			return true;
		}
	};
	
	private final int priorita;

	private TipoVeicolo(int priorita) {
		this.priorita = priorita;
	}

	public int getPriorita() {
		return priorita;
	}
	
	public abstract  boolean puoPassareConRosso();
	
}
