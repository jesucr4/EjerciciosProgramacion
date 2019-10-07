package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio03_bloque2_MultiplosMenores100 {

	public static void main(String[] args) {
		// pedimos al usuario que introduzca el número del que quiere sacar sus múltiplos
		int multiplo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número del que quiere saber sus múltiplos:"));
		// realizamos bucle for para ver multiplos
		for (int i = 0; i < 100; i+=multiplo) {
			
			System.out.println(i + " es múltiplo de " + multiplo + " hasta llegar al número 100");
		}
	}

}
