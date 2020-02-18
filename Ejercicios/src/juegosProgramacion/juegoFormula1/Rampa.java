package juegoFormula1;

import java.awt.Color;
import java.awt.Graphics;

import tema5_arrays.Utils;

public class Rampa extends Obstaculo {

	
	
	/*public Rampa(int posicion, int impulso, int cantidadPosicionesOcupa) {
		super(posicion, impulso, cantidadPosicionesOcupa);
		// TODO Auto-generated constructor stub
	}*/


	public Rampa() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Rampa(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	//ser método que devuelva un entero que sea la nueva posición en la que se va a quedar el vehículo después de caer ahí
	public void impulsaPosiciones() {
			
		
	}

	@Override
	public void paint(Graphics g) {
	g.setColor(Color.GREEN);
	g.fillArc(this.posicion, this.pista.getY() + 5, 25, 25, 90, 45);
		
	}

}
