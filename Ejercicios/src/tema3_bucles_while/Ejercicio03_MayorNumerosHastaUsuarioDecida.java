package tema3_bucles_while;

import javax.swing.JOptionPane;

public class Ejercicio03_MayorNumerosHastaUsuarioDecida {

	public static void main(String[] args) {
		int mayor = 0, num = -1;
		
		
		while ( num != 0) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca n�mero (0 -> Salir): "));
			if(num > mayor && num != 0) {
					mayor = num;
				}
			}
		System.out.println("El número mayor es " + mayor);
		}
		
		
		
	}
	
	


