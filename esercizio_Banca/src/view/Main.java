package view;

import controller.ControlBanca;

public class Main {
	public static ControlBanca bancaCtrl;
	
	public static void main(String[] args) {
		bancaCtrl = new ControlBanca("Gabriel", "Bejan", "sdasdas", 2000.0);
	}
}
