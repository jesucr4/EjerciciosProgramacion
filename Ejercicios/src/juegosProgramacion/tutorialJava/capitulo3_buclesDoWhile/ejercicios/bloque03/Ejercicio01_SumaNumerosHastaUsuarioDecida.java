package tutorialJava.capitulo3_buclesDoWhile.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio01_SumaNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int suma = 0, num = -1;
		

		do  {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número (0 -> Salir): "));
			suma = suma + num;
		} while ( num != 0);
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Total acumulado " + suma);

	}

}
