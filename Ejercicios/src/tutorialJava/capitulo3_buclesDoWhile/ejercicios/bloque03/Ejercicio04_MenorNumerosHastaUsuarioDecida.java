package tutorialJava.capitulo3_buclesDoWhile.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio04_MenorNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int menor = 0, num ;

		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número (0 -> Salir): "));
			
				if (num < menor && num != 0) {
					menor = num;
				}
			
		}while (num!=0);
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Menor total " + menor); 
	}
	
	

}
