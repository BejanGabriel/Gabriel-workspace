package controller;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Servizio;
import service.ServizioService;

public class ServizioMenu {

	private static Scanner scan = new Scanner(System.in);
	private static final ServizioService ss = new ServizioService();
	private static final ClienteMenu cm = new ClienteMenu();
	
	public ServizioMenu() {
		
	}
	
	public void mostraMenu() {
		
		boolean continua = true;
		
		System.out.println("=== Gestione Nota ===");
		Cliente clienteScelto = cm.scegliCliente("Su quale cliente vuoi operare?");
		
		do {
			System.out.println("1. Compra servizio");
			System.out.println("2. Rimuovi servizio");
			System.out.println("3. Mostra servizi cliente");
			System.out.println("4. Cambia cliente");
			System.out.println("0. Torna Indietro");
			
			int scelta = scan.nextInt();
			scan.nextLine();
			
			switch(scelta) {
			case 1:
				acquistaServizio(clienteScelto);
				break;
			case 2:
				rimuoviServizio(clienteScelto);
				break;
			case 3:
				vediServiziCliente(clienteScelto);
				break;
			case 4:
				clienteScelto = cm.scegliCliente("-- Cambia cliente");
			case 0:
				System.out.println("\nStai tornando al menu cliente...\n");
				continua = false;
				break;
			default:
				throw new IllegalArgumentException("Non ho capito il comando, hai inserito: " + scelta);
			}
			
		}while (continua);
	}
	
	public void menuServiziGenerali() {
		boolean continua = true;
		System.out.println("---- Menu gestione generale servizi ----");
		do {
			System.out.println("Segli l'operazione da svolgere"); 
			System.out.println("1. Aggiungi Servizio");
			System.out.println("2. Modifica Servizio");
			System.out.println("3. Elimina Servizio");
			System.out.println("4. Mostra lista servizi");
			System.out.println("5. Torna indietro.");
			
			int scelta = scan.nextInt();
			scan.nextLine();
			switch(scelta) {
			case 1:
				aggiungiServizioAllaLista();
				break;
			case 2: 
				modificaServizioDallaLista();
				break;
			case 3:
				modificaServizioDallaLista();
				break;
			case 4:
				mostraListaServizi();
				break;
			case 5:
				continua = false;
				break;
			default:
				throw new IllegalArgumentException("Non ho capito il comando, hai inserito: " + scelta);
					
			}
		}while(continua);
	}

	public void mostraListaServizi() {
		System.out.println("==== Lista dei Servizi ====");
		List<Servizio> listaServizi = ss.getAllServizi();
		int i = 0;
		for(Servizio s : listaServizi) {
			System.out.println("| ID-Servizio: " + s.getIdServizio() + "\n| Nome Servizio: " + s.getNomeServizio()
			+ "\n| Descrizione: " + s.getDescrizione() + "\n| Prezzo: " + s.getPrezzo());
			System.out.println("--------------------------------");
		}

	}

	private void modificaServizioDallaLista() {
		Servizio servizioScelto = scegliServizio("Quale servizio vuoi modificare?");
		System.out.println("Inserisci il nuovo titolo del servizio");
		String nuovoTit = scan.nextLine();
		if(!nuovoTit.isBlank())servizioScelto.setNomeServizio(nuovoTit);
		System.out.println("Inserisci la nuova descrizione");
		String nuovaDesc = scan.nextLine();
		if(!nuovaDesc.isBlank())servizioScelto.setDescrizione(nuovaDesc);
		double nuovoPrezzo = scan.nextDouble();
		scan.nextLine();
		if(nuovoPrezzo != servizioScelto.getPrezzo()) servizioScelto.setPrezzo(nuovoPrezzo);
		ss.modificaServizio(servizioScelto);
	}

	private void aggiungiServizioAllaLista() {
		System.out.println("Inserisci titolo");
		String titoloServ = scan.nextLine();
		System.out.println("Inserisci descrizione");
		String descrizioneServ = scan.nextLine();
		System.out.println("Inserisci prezzo");
		double prezzoServ = scan.nextDouble();
		ss.aggiungiServizio(titoloServ, descrizioneServ, prezzoServ);
		
		
	}

	private void vediServiziCliente(Cliente clienteScelto) {
		System.out.println("---- Servizi acquistati da [" + clienteScelto.getNomeAzienda() + "] ----");
		List<Servizio> serviziCliente =  ss.getServizioByClienteID(clienteScelto.getIdCliente());
		
		for (Servizio s : serviziCliente) {
			System.out.println("| Nome Servizio: " + s.getNomeServizio() + "\n| Descrizione: " + s.getDescrizione());
			System.out.println("----------------------------------------------------------------------");
		}
	}

	private void rimuoviServizio(Cliente clienteScelto) {
		System.out.println("---- Rimozione Servizio ----");
		ss.cancellaServizio(clienteScelto.getIdCliente());
		
	}

	private void acquistaServizio(Cliente clienteScelto) {
		Servizio s = scegliServizio("Quale servizio vuoi aggiungere");
		ss.associaServizioCliente(clienteScelto.getIdCliente(), s.getIdServizio());
	}
	
	public static Servizio scegliServizio(String msg) {
		List<Servizio> listaServizi = ss.getAllServizi();
		System.out.println(msg);
		System.out.println("---------------------------");
		for(Servizio s : listaServizi) {
			System.out.println("ID-Servizio: " + s.getIdServizio() + "\n| Nome Servizio: " + s.getNomeServizio() + "\n| Descrizione: " + s.getDescrizione()
			+ "\n| Prezzo: " + s.getPrezzo());
			System.out.println("--------------------------");
		}
		int servizoScelto = scan.nextInt();
		return listaServizi.get(servizoScelto-1);
		
	}
}
