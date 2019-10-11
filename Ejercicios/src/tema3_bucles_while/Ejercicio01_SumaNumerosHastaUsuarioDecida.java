package tema3_bucles_while;

import javax.swing.JOptionPane;

public class Ejercicio01_SumaNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int suma = 0, num = -1;
		

		while ( num != 0) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca n�mero (0 -> Salir): "));
			suma = suma + num;
		}
		
		System.out.println("La suma de los valores introducidos es " + suma);

	}

}
