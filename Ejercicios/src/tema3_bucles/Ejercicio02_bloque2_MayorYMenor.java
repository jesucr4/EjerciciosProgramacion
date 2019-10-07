package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque2_MayorYMenor {

	public static void main(String[] args) {
		int mayor = 0; 
		int menor = 0;
		// pedimos al usuario que introduzca los números que quiera para buscar cual es el mayor y el menor
		int cantidadNumeros = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad de números sobre los que quiere buscar"
				+ " mayor y menor"));
		
		for (int i = 0; i < cantidadNumeros; i++) {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca números para ver cual es mayor y menor"));
		numero = mayor; 
		
	}
	}
}
