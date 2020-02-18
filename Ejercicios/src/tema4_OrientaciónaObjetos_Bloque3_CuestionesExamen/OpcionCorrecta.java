package tema4_OrientaciónaObjetos_Bloque3_CuestionesExamen;

import javax.swing.JOptionPane;

public class OpcionCorrecta extends Cuestion {

	String opciones [];

	
	
	
	public OpcionCorrecta(String enunciado, int respuestaCorrecta, String[] opciones) {
		super(enunciado, respuestaCorrecta);
		this.opciones = opciones;
	}




	@Override
	public int mostrarEnPantalla() {
		String enunciadoAMostrar = this.enunciado;
		for (int i = 0; i < this.opciones.length; i++ ) {
			enunciadoAMostrar = enunciadoAMostrar + "\n" + (i+1) + ".-" + this.opciones[i];
		}
		return Integer.parseInt(JOptionPane.showInputDialog(enunciadoAMostrar));
	}




	
	
	
}

	
	