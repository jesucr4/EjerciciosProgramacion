package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque2_MayorYMenor {

	public static void main(String[] args) {
		//declaramos variables mayor y menor
		int mayor = 0, menor = 0;
		//pedimos al usuario que indique la cantidad de números que va a introducir
		int cantidadNumeros = Integer.parseInt(JOptionPane.showInputDialog("Cu�ntos n�meros va a introducir?"));
		//pedimos el primer número para que este sea tanto el mayor como el menor
		int primerNumero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer n�mero"));
		menor=primerNumero;
		mayor = primerNumero;
		for (int i=0 ; i<cantidadNumeros-1; i++) {
			int numeros = Integer.parseInt(JOptionPane.showInputDialog("Introduzca n�meros para obtener mayor y menor"));
			
			if (numeros < menor) {
				menor = numeros;
			}else {
				if (numeros > mayor) {
					mayor = numeros;
				}
			}
		}
		System.out.println("El n�mero mayor es "+ mayor + " y el n�mero menor es " + menor);
	}
}

