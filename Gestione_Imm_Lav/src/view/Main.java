package view;

import controller.CorsoController;

public class Main {
public static void main(String[] args) {
	CorsoController corsoCtrl = new CorsoController();
	corsoCtrl.addCorso("Java", "Scemo Chi Legge");
	corsoCtrl.visualizzaCorsi();
}
}
