package gestioneRistorante;

public enum Piatto {

	BRUSCHETTA("Bruschetta al Pomodoro", CategoriaPiatto.ANTIPASTO, 5.50, true),
	INSALATA_MISTA("Insalata Mista", CategoriaPiatto.ANTIPASTO, 6.00, true),

	CARBONARA("Spaghetti alla Carbonara", CategoriaPiatto.PRIMO, 12.00, false),
	RISOTTO_FUNGHI("Risotto ai Funghi Porcini", CategoriaPiatto.PRIMO, 14.00, true),
	LASAGNE("Lasagne alla Bolognese", CategoriaPiatto.PRIMO, 11.50, false),

	BISTECCA("Bistecca alla Griglia", CategoriaPiatto.SECONDO, 18.00, false),
	POLLO_ARROSTO("Pollo Arrosto", CategoriaPiatto.SECONDO, 13.00, false),

	VERDURE_GRIGLIATE("Verdure Grigliate", CategoriaPiatto.CONTORNO, 5.00, true),
	PATATE_FORNO("Patate al Forno", CategoriaPiatto.CONTORNO, 4.50, true),

	TIRAMISU("Tiramisù", CategoriaPiatto.DESSERT, 6.00, true);

	private final String nome;
	private final CategoriaPiatto categoria;
	private final double prezzo;
	private boolean vegetariano;
	
	private Piatto(String nome, CategoriaPiatto categoria, double prezzo, boolean vegetariano) {
		this.nome = nome;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.vegetariano = vegetariano;
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}

	public String getNome() {
		return nome;
	}

	public CategoriaPiatto getCategoria() {
		return categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}
	
	}
