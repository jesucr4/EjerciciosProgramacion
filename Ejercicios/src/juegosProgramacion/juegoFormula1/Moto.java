package juegoFormula1;

import java.awt.Color;
import java.awt.Graphics;

public class Moto extends Vehiculo {

	

/*	public Moto(String nombre, String color) {
		super(nombre, color);
		// TODO Auto-generated constructor stub
	}*/

	public Moto() {
		// TODO Auto-generated constructor stub
	}
	

	public Moto(String nombre, Color color, Pista pista) {
		super(nombre, color, pista);
		// TODO Auto-generated constructor stub
	}

	

	public Moto(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(getColor()); 
		g.fillOval(this.pista.getX(), this.pista.getY() + 5, 20, 20);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return super.getColor();
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		super.setColor(color);
	}


	@Override
	public void avanzaPosiciones() {
		// TODO Auto-generated method stub
		super.avanzaPosiciones();
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
}

	