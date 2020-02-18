package tutorialJava.capitulo3_buclesDoWhile.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio03_MayorNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int mayor = 0, num ;

		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número (0 -> Salir): "));
			
				if (num > mayor && num != 0) {
					mayor = num;
				}
			
		}while (num!=0);
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Mayor total " + mayor); 
	
	
	
	}
}
