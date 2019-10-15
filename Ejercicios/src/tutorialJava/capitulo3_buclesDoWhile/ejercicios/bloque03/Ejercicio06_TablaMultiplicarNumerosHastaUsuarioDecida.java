package tutorialJava.capitulo3_buclesDoWhile.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio06_TablaMultiplicarNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int num = -1;
		String tablaMultiplicar = "";

		
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
				"Introduzca número (0 -> Salir): "));
			
			if (num != 0) {
				tablaMultiplicar = "";
				for (int i = 1; i < 11; i++) {
					tablaMultiplicar += num + " x " + i + " = " + 
							(num * i) + "\n";
				}
				JOptionPane.showMessageDialog(null, tablaMultiplicar); 
			}
		}while (num !=0);
		
	}
	
	

}
