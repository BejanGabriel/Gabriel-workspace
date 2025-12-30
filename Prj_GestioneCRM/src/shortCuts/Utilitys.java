package shortCuts;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import database.DBConnection;
// Può sembrare una classe inutile, e sicuramente lo è per un progetto cosi piccolo. Ma se mai mi dovessi ampliare, o cambiare db
public abstract class Utilitys {
	// Connessione al db
	protected Connection conn = DBConnection.getInstance().getConnessione();
	
	// metodo generico per la scelta di un elemento
	
	protected static <T> T scegliDaLista(List<T> lista) {
		Scanner scan = new Scanner(System.in);
		int contatore = 0;
		for(T elemento : lista) {
			System.out.println(++contatore + ") " + elemento.toString());
		}
		int scelta = scan.nextInt();
		scan.nextLine();
		return lista.get(scelta-1);
	}
	
	// metodo validatore da usere nelle classi DAOImpl per controllare la correttezza del dato inserito / ricevuto.
	
}
