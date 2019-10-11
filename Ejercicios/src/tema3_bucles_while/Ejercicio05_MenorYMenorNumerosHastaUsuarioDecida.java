package tema3_bucles_while;

import javax.swing.JOptionPane;

public class Ejercicio05_MenorYMenorNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int menor = 0, mayor = 0, num = -1;

		
		for (int i = 0; num != 0; i++) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca n�mero (0 -> Salir): "));
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
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Mayor " + mayor + 
				" y menor " + menor); 
	}
	
	

}
