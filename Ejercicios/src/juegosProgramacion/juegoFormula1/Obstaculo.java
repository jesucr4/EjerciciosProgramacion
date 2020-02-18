package juegoFormula1;

import java.awt.Graphics;

import examen_Jesus_Cano_Ruiz.Utils;

public abstract  class Obstaculo extends Actor {

	public int posicion;
	public int impulso;
	public int cantidadPosicionesOcupa;
	public Pista pista;
	
	public Obstaculo() {
		super();
		this.posicion = Utils.obtenerNumeroAzar(0, 100);
		this.impulso = Utils.obtenerNumeroAzar(2, 6);
		this.cantidadPosicionesOcupa = this.posicion + Utils.obtenerNumeroAzar(1, 4);
		this.pista = pista;
	}
	
	
	public Obstaculo(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return super.getX();
	}



	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		super.setX(x);
	}



	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return super.getY();
	}



	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		super.setY(y);
	}



	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}



	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
	}



	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}



	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		super.setHeight(height);
	}



	



	@Override
	public String toString() {
		return "Obstaculo [posicion=" + posicion + ", impulso=" + impulso + ", cantidadPosicionesOcupa="
				+ cantidadPosicionesOcupa + "]";
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
