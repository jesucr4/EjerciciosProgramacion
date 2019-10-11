package tema3_bucles_while;

import javax.swing.JOptionPane;

public class Ejercicio07_ContadorPositivosYNegativosHastaUsuarioDecida {

	public static void main(String[] args) {
		int num = -1, contPos = 0, contNeg = 0;

		
		for (; num != 0;) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
				"Introduzca n�mero (0 -> Salir): "));

			if (num < 0) { // Es negativo
				contNeg++;
			}
			if (num > 0) { // Es positivo
				contPos++;
			}
		}
		
		// Impresi�n de los resultados
		JOptionPane.showMessageDialog(null, "Positivos " + contPos + 
				" y negativos " + contNeg);
	}
	
	

}
