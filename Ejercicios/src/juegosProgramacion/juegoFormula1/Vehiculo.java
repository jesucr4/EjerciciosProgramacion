package juegoFormula1;

import java.awt.Color;
import java.awt.Graphics;

import tema5_arrays.Utils;

public class Vehiculo extends Actor {


	public String nombre;
	public int posicionVehiculo = 0;
	private Color color;
	public Pista pista;	
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	

	


	public Vehiculo(String nombre, Color color, Pista pista) {
		super();
		this.nombre = nombre;
		this.posicionVehiculo = posicionVehiculo;
		this.color = color;
		this.pista = pista ;
	}



	



	public Vehiculo(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}






	public  void paint (Graphics g) {
		this.pista.paint(g);
	}
		
		// modificar este método para que deje de dar fallo y no pase de 100
	public void avanzaPosiciones () {
		/*for (this.posicionVehiculo = 0; this.posicionVehiculo <pista.longitudPista + 1;) {
			this.posicionVehiculo += Utils.obtenerNumeroAzar(2, 8);
			System.out.println(nombre + " se encuentra en la posición "  + this.posicionVehiculo);
			if ( this.posicionVehiculo >= pista.longitudPista ) {
				System.out.println( nombre + " ha acabado la carrera");
			}
		}*/
		
		this.posicionVehiculo +=Utils.obtenerNumeroAzar(2, 8);
		
		
	}
	

	
	@Override
	public String toString() {
		return "Vehiculo [nombre=" + nombre + ", posicionVehiculo=" + posicionVehiculo + ", color=" + color + ", pista="
				+ pista + "]";
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}






	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	

}
