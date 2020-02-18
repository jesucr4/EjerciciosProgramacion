package tema4_OrientaciónaObjetos_Bloque3_CuestionesExamen;

import javax.swing.JOptionPane;

public class VerFal extends Cuestion {

	
	public VerFal() {
		// TODO Auto-generated constructor stub
	}

	public VerFal(String enunciado, int respuestaCorrecta) {
		super(enunciado, respuestaCorrecta);
	}

	@Override
	public int mostrarEnPantalla() {
		return Integer.parseInt(JOptionPane.showInputDialog(this.enunciado + "\n1.- Verdadero\n2.-Falso"));
	}

	


	
	

}
