package view;
import dao.ClienteDAOImpl;
import dao.GenericDAO;
import dao.UtenteDAOImpl;
import database.DBConnection;
import model.Cliente;
import model.Utente;
public class Main {
	public static void main(String[] args) {
		
		// apertura della connessione all'avvio del main.
		DBConnection connessione = DBConnection.getInstance();
		connessione.getConnessione();
		
		//TESTING UTENTE -> OK!
//		Utente utente = new Utente();
//		utente.setNomeUtente("MARCO");
//		utente.setRuolo("PAZZO");
//		utente.setEmail("PAZZ.MARC@mail.com");
//		utente.setPassword("123");
		
		//TESTING CLIENTE -> TESTING
		Cliente cliente = new Cliente();
		cliente.setNomeAzienda("Pippo.s.r.l");
		cliente.setRefereneAzienda("Luca Marconi");
		cliente.setCategoriaMerceologica("Sviluppatore");
		cliente.setTipologiaCliente("In Acquisizione");
		
		
		GenericDAO<Cliente> gdU = new ClienteDAOImpl();
		//gdU.create(cliente);
		gdU.readAll();
		
		gdU.assegnazioneByID(4, 1);
		
		
		
		
		
		
		
		
		//questa verrà avviato solo dopo aver finito tutto quello che volevo fare.
		//connessione.close();
		
	}
}
