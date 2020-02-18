package tutorialJava.capitulo3_buclesDoWhile.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio02_MediaNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int suma = 0, num = -1, contMedia = -1;

		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número (0 -> Salir): "));
			suma = suma + num;
			contMedia++;
		} while (num !=0);
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Media total " + 
				((float) suma / (contMedia))); 
	}
	
	

}
