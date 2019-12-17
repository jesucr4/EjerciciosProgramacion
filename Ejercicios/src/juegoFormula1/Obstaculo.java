package juegoFormula1;

import java.awt.Graphics;

import examen_Jesus_Cano_Ruiz.Utils;

public abstract class Obstaculo {

	private int posicion;
	private int impulso;
	public int cantidadPosicionesOcupa;
	
	public Obstaculo(int posicion, int impulso, int cantidadPosicionesOcupa) {
		super();
		this.posicion = Utils.obtenerNumeroAzar(0, 100);
		this.impulso = Utils.obtenerNumeroAzar(2, 6);
		this.cantidadPosicionesOcupa = this.posicion + Utils.obtenerNumeroAzar(1, 4);
	}

	public int getCantidadPosicionesOcupa() {
		return cantidadPosicionesOcupa;
	}

	public void setCantidadPosicionesOcupa(int cantidadPosicionesOcupa) {
		this.cantidadPosicionesOcupa = cantidadPosicionesOcupa;
	}

	public int getImpulso() {
		return impulso;
	}

	public void setImpulso(int impulso) {
		this.impulso = impulso;
	}

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
