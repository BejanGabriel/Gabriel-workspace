package view;
import java.util.List;

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
		
//		GenericDAO<Utente> gdU = new UtenteDAOImpl();
//		Utente u = gdU.readByID(1);
//		System.out.println(u);
		//TESTING CLIENTE -> OK!
//		Cliente cliente = new Cliente();
//		cliente.setNomeAzienda("Pippo.s.r.l");
//		cliente.setRefereneAzienda("Luca Marconi");
//		cliente.setCategoriaMerceologica("Sviluppatore");
//		cliente.setTipologiaCliente("In Acquisizione");
		
		// UPDATING utente_assegnato FK -> OK!
		GenericDAO<Cliente> gdC = new ClienteDAOImpl();
		//gdU.create(cliente);
		List<Cliente> listaClienti = gdC.readAll();
		Cliente c = gdC.readByID(1);
		System.out.println("=== Cliente Singolo ===\n" + c);
		System.out.println("=== Lista Clienti ===\n" + listaClienti);
		
		gdC.assegnazioneByID(3, 4);
		
		
		
		
		
		
		
		
		//questa verrà avviato solo dopo aver finito tutto quello che volevo fare.
		//connessione.close();
		
	}
}
