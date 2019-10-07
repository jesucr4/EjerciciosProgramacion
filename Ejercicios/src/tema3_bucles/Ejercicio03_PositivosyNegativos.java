package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio03_PositivosyNegativos {

	public static void main(String[] args) {
		
		// pedimos al usuario la cantidad de números que quiera introducir
		int contPositivos = 0;
		int contNegativos = 0;
				int numUsuario = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de números quiera introducir"));
				//pedimos números al usuario
				
				for (int i=0; i<numUsuario; i++) {
					int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
					if (num > 0) {
						contPositivos++;
					}
					else  {
						contNegativos++;
	}
				}
	}
}
