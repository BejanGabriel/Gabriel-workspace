package controller;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import service.ClienteService;

public class ClienteMenu {

	private static Scanner scan = new Scanner(System.in);
	private static final ClienteService cs = new ClienteService();
	private static UtenteMenu um = new UtenteMenu();

	public ClienteMenu() {
	}

	public static Cliente scegliCliente() {
		List<Cliente> clienti = cs.getAllClienti();
		int contatore = 0;
		for (Cliente c : clienti) {
			System.out.println(++contatore + ") " + c.getRefereneAzienda());
		}
		System.out.println("Seleziona un utente: ");
		int scelta = scan.nextInt();
		scan.nextLine();
		return clienti.get(scelta - 1);
	}
	
	public void mostraMenu() {
		boolean continua = true;
		do {
			System.out.println("1. Crea Cliente");
			System.out.println("2. Modifica Cliente");
			System.out.println("3. Trova Cliente");
			System.out.println("4. Mostra lista Clienti");
			System.out.println("5. Elimina un Cliente");
			System.out.println("6. Fissa Appuntamento");
			System.out.println("7. Acquista un servizio");
			System.out.println("8. Vedi lista appuntamenti del cliente");
			System.out.println("9. Vedi servizi Cliente");
			System.out.println("0. Torna al menu Generico");
			int scelta = scan.nextInt();
			scan.nextLine();
			switch (scelta) {
			case 1: 
				aggiungiCliente();
				break;
			case 2:
				modificaCliente();
				break;
			case 3:
				trovaCliente();
				break;
			case 4:
				mostraClienti();
				break;
			case 5:
				eliminaCliente();
				break;
			case 6:
				fissaAppuntamento();
				break;
			case 7:
				mostraAppuntamentiCliente();
				break;
			case 0:
				continua = false;
				break;
			default:
				throw new IllegalArgumentException("Non ho capito il comando, hai inserito: " + scelta);
			}
		} while (continua);
	}

	private void mostraAppuntamentiCliente() {
		// TODO Auto-generated method stub
		
	}

	private void fissaAppuntamento() {
		// TODO Auto-generated method stub
		
	}

	private void mostraClienti() {
		// TODO Auto-generated method stub
		
	}

	private void trovaCliente() {
		// TODO Auto-generated method stub
		
	}

	private void modificaCliente() {
		// TODO Auto-generated method stub
		
	}

	public void aggiungiCliente() {

		System.out.println("Inserisci nome azienda: ");
		String nomeAzienda = scan.nextLine();
		System.out.println("Inserisci referente azienda: ");
		String referenteAzienda = scan.nextLine();
		System.out.println("Inserisci la sua categoria merceologica: ");
		String catMerceologica = scan.nextLine();
		System.out.println("Inserisci il tipo di cliente: ");
		String tipoCliente = scan.nextLine();
		System.out.println("Segli l'utente associato:");
		int utenteAssociato = um.scegliUtente().getIdUtente();
		cs.aggiungiCliente(nomeAzienda, referenteAzienda, catMerceologica, tipoCliente, utenteAssociato);

	}

	public void eliminaCliente() {
		System.out.println("Quale cliente vuoi eliminare?");
		int idCliente = scegliCliente().getIdCliente();
		cs.eliminaCliente(idCliente);
	}
}
