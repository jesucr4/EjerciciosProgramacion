package juegoFormula1;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		//creamos pistas para después poder relacionar cada coche con una pista
		Pista pista1 = new Pista("Pista1");
		Pista pista2 = new Pista("Pista2");
		Pista pista3 = new Pista("Pista3");
		Pista pista4 = new Pista("Pista4");
		
		//System.out.println(pista1.toString());

		
		// creamos cada vehículo ya relacionado con cada pista
		Coche jugador1 = new Coche("Alonso", Color.BLUE, pista1);
		Coche jugador2 = new Coche("jug2", Color.RED, pista2);
		Moto jugador3 = new Moto("jug3", Color.GREEN, pista3);
		Moto jugador4 = new Moto("jug4", Color.ORANGE, pista4);
		
		Vehiculo carrera[] = new Vehiculo [4];
		for (int i = 0; i < carrera.length; i++) {
			carrera[0] = jugador1; 
		}
		
		for (int i = 0; i < 1; i++ ) {
			jugador1.avanzaPosiciones();
			System.out.println(jugador1.toString());
			/*jugador2.avanzaPosiciones();
			System.out.println(jugador2.toString());
			jugador3.avanzaPosiciones();
			System.out.println(jugador3.toString());
			jugador4.avanzaPosiciones();
			System.out.println(jugador4.toString());*/
			
		}
		
		//crear array de vehículos para que los vehículos vayan avanzando en orden
		// realizar un bucle para que los jugadores vayan avanzando en orden con el método avanzaPosiciones
		
		
		
		
	}

}
