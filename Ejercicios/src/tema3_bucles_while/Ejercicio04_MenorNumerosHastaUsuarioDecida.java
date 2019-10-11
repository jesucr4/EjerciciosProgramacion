package tema3_bucles_while;

import javax.swing.JOptionPane;

public class Ejercicio04_MenorNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int menor = 0, num = -1;

		
		while ( num != 0) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca n�mero (0 -> Salir): "));
			if (num == 0) {
				menor = num;
			}else {
				if (num < menor && num != 0) {
					menor = num;
				}
			}
		}
		System.out.println("El número menor de los que ha introducido el usuario es " + menor);
		}
		
		 
	}
	
	


