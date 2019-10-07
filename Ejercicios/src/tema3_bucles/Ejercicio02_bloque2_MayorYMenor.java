package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque2_MayorYMenor {

	public static void main(String[] args) {
		int mayor = 0, menor = 0;
		int cantidadNumeros = Integer.parseInt(JOptionPane.showInputDialog("Cuántos números va a introducir?"));
		int primerNumero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer número"));
		menor=primerNumero;
		mayor = primerNumero;
		for (int i=0 ; i<cantidadNumeros-1; i++) {
			int numeros = Integer.parseInt(JOptionPane.showInputDialog("Introduzca números para obtener mayor y menor"));
			
			if (numeros < menor) {
				menor = numeros;
			}else {
				if (numeros > mayor) {
					mayor = numeros;
				}
			}
		}
		System.out.println("El número mayor es "+ mayor + " y el número menor es " + menor);
	}
}

