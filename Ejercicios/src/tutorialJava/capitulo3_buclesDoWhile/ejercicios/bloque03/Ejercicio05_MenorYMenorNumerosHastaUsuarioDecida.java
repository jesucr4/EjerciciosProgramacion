package tutorialJava.capitulo3_buclesDoWhile.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio05_MenorYMenorNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int menor = 0, mayor = 0, num = -1;
		
		
		do {
			for (int i = 0; num != 0; i++) {
				num = Integer.parseInt(JOptionPane.showInputDialog(
						"Introduzca número (0 -> Salir): "));
				if (i == 0) {
					menor = num;
					mayor = menor;
				}
				else {
					if (num < menor && num != 0) {
						menor = num;
					}
					if (num > mayor && num != 0) {
						mayor = num;
					}
				}
			}
			
		} while (num!=0);
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Mayor " + mayor + 
				" y menor " + menor); 
		
	}
}
