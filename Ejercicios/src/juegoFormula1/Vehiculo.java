package juegoFormula1;

import java.awt.Graphics;

import tema5_arrays.Utils;

public abstract class Vehiculo {

	private String nombre;
	private int posicionVehiculo = 0;
	private String color;
	private Pista p = new Pista();
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Vehiculo(String nombre, int posicionVehiculo, String color, int pista) {
		super();
		this.nombre = nombre;
		this.posicionVehiculo = posicionVehiculo;
		this.color = color;
		
	}


	public Vehiculo(String nombre, int posicionVehiculo, String color, Pista p) {
		super();
		this.nombre = nombre;
		this.posicionVehiculo = posicionVehiculo;
		this.color = color;
		this.p = p;
	}


	public abstract void paint (Graphics g);
		
	public void avanzaPosiciones () {
		for (int i=posicionVehiculo; i<=100; i++) {
			this.posicionVehiculo = Utils.obtenerNumeroAzar(2, 8);
		}
		
	}


	public Pista getP() {
		return p;
	}



	public void setP(Pista p) {
		this.p = p;
	}



	
	@Override
	public String toString() {
		return "Vehiculo [nombre=" + nombre + ", posicionVehiculo=" + posicionVehiculo + ", color=" + color + ", p=" + p
				+ "]";
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

	

}
