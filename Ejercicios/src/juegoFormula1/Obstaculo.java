package juegoFormula1;

import java.awt.Graphics;

public abstract class Obstaculo {

	private int posicion;
	
	public Obstaculo(int posicion) {
		this.posicion = posicion;
	}
	
	public abstract void paint (Graphics g);

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	

}
