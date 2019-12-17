package juegoFormula1;

import java.awt.Graphics;

public abstract class Vehiculo {

	private String nombre;
	private int posicionVehiculo = 0;
	private String color;
	private int pista;
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Vehiculo(String nombre, int posicionVehiculo, String color, int pista) {
		super();
		this.nombre = nombre;
		this.posicionVehiculo = posicionVehiculo;
		this.color = color;
		this.pista = pista;
	}



	public abstract void paint (Graphics g);
	
	public void avanza () {
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosicionVehiculo() {
		return posicionVehiculo;
	}

	public void setPosicionVehiculo(int posicionVehiculo) {
		this.posicionVehiculo = posicionVehiculo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPista() {
		return pista;
	}

	public void setPista(int pista) {
		this.pista = pista;
	}
	

}
