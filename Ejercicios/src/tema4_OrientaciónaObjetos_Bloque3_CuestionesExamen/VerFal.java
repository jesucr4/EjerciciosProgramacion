package tema4_OrientaciónaObjetos_Bloque3_CuestionesExamen;

import javax.swing.JOptionPane;

public class VerFal extends Cuestion {

	private int verdadero;
	private int falso;
	
	public VerFal() {
		// TODO Auto-generated constructor stub
	}

	public VerFal(String enunciado, int respuestaCorrecta, int verdadero, int falso) {
		super(enunciado, respuestaCorrecta);
		this.verdadero = verdadero;
		this.falso = falso;
	}

	@Override
	public void mostrarEnPantalla() {
		//introducir JOptionPane en una variable y mostrar este a través de la variable
		/**System.out.println(JOptionPane.showInputDialog(getEnunciado()+ 
			"\nIntroduzca: \n 1. Verdadero \n 2. Falso"	));
		**/
	}

	@Override
	public void evaluar() {
		

	}

	public VerFal(int verdadero, int falso) {
		super();
		this.verdadero = verdadero;
		this.falso = falso;
	}

	public int getVerdadero() {
		return verdadero;
	}

	public void setVerdadero(int verdadero) {
		this.verdadero = verdadero;
	}

	public int getFalso() {
		return falso;
	}

	public void setFalso(int falso) {
		this.falso = falso;
	}

	@Override
	public String toString() {
		return "VerFal [verdadero=" + verdadero + ", falso=" + falso + "]";
	}
	
	

}
