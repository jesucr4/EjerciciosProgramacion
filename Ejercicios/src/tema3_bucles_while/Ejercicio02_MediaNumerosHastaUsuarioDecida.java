package tema3_bucles_while;

import javax.swing.JOptionPane;

public class Ejercicio02_MediaNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int suma = 0, num = -1, i=0;
		int contMedia = -1;
		while ( num != 0) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca n�mero (0 -> Salir): "));
			suma = suma + num;
			contMedia++;
		}
		
		// Sacamos el mensaje final con el valor acumulado
		System.out.println("La media de los números introducidos es " + (suma/contMedia));
	}
	
	

}
