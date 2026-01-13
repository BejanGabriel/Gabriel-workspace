package controller;

import java.util.Scanner;

import service.NotaService;

public class NotaMenu {

	private static Scanner scan = new Scanner(System.in);
	private static final NotaService ns = new NotaService();
	
	public NotaMenu() {
		
	}
	// per come l'ho pensato io, decido di segliere prima un cliente sulla quale fare operazioni, qui nella gestione nota, poi ci opero.
	// vi sarà anche un metodo per poter segliere un altro utente, o anzi tutto dentro un solo metodo che verra chiamato al momento opportuno.
	
	public void mostraMenu() {
		System.out.println("=== Gestione Nota ===");
		System.out.println("");
	}
}
