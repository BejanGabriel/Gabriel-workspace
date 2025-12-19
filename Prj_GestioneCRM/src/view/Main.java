package view;
import database.DBConnection;
public class Main {
	public static void main(String[] args) {
		
		// apertura della connessione all'avvio del main.
		DBConnection connessione = DBConnection.getInstance();
		connessione.getConnessione();
		
		
		
		
		
		
		
		
		
		
		
		//questa verrà avviato solo dopo aver finito tutto quello che volevo fare.
		connessione.close();
		
	}
}
