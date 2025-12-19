package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/gestione_crm";
    private static final String USER = "tester";
    private static final String PASS = "TesterProgetti";

    private static volatile DBConnection instance;
    //Volatile garantisce la visibilità di 'instance' tra i thread, impedendone il
    // riordino delle istruzioni
    private Connection connection;

    private DBConnection() {} //dentro questo costruttore potremmo mettere i dati di connessione al db
    // cosi quando richiamato, l'utente dovrà inseritli, non serve per questo progetto.

    // metodo usato per multi-thread, per mono-thread non serve.
    public static DBConnection getInstance() {
        if (instance == null) {
        	//Se instance è null, sincronizzati con la classe del DBConnection, se no, no.
        	// serve a evitare di farlo quando esiste gia
            synchronized (DBConnection.class) {
            	// Solo un thread entra, tutti gli altri devono aspettare che finisca e si liberi il posto
                if (instance == null) {  
                	//mentre si aspettava il lock, un altro thread poterbbe aver gia creato
                	// completamente l'istanza, quindi questo if serve ad evitare duplicati.
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnessione() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Connessione al DB stabilita");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Errore di connessione al DB", e);
        }
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connessione chiusa correttamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
