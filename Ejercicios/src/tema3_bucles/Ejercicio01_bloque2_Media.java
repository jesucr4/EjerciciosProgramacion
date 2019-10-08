package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio01_bloque2_Media {

	public static void main(String[] args) {
		//pedimos al usuario la cantidad de números sobre los que quiere realizar la media
		int mediaNumeros = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad de números de los que quiere realizar la media"));
		float suma = 0;
		//realizamos bucle for
		for (int i=0; i < mediaNumeros; i++) {
			//pedimos al usuario que introduzca los números que vamos a sumar para posteriormente realizar su media
			int numIntroducidos = Integer.parseInt(JOptionPane.showInputDialog("Introduzca números para realizar media"));
			suma +=numIntroducidos; 
			
		}
		System.out.println("La media de los números introducidos es igual " + (suma / mediaNumeros));

	}

}
