
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {
	
	private static final String URL = "jdbc:/mysql://localhost:3306/gestione_scuola";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	//Uso Singleton perche cosi è più facile e sicuro.
	
	private static ConnectionDAO instance;
	
	private ConnectionDAO() {
		//Invio un messaggio di connesione avvenuta
		try {
			System.out.println("Collegamento stabilito con successo!");
		}catch (Exception e) {
			System.out.println("Impossibile stabilire la connessione.");
		}
	}
	
	//restituisco l'istanza singleton
	public static ConnectionDAO getInstance() {
		if(instance == null) {
			instance = new ConnectionDAO();
		}
		return instance;
	}
	
	public Connection getConnessione() {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void closeConnessione(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// metodo per testare la connessione
	public void testaConnessione() {
		Connection conn = null;
		try {
			conn= getConnessione();
			System.out.println("Connessione avvenuta");
		} catch (Exception e) {
			System.out.println("Connessione non avvenuta");
		}finally {
			closeConnessione(conn);
		}
	}
		
}
