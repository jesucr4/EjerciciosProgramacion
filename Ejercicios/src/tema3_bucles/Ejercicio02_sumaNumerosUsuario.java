package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio02_sumaNumerosUsuario {

	public static void main(String[] args) {
		// pedimos al usuario la cantidad de números que quiera introducir
		int numUsuario = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de números quiera introducir"));
		//pedimos números al usuario
		int suma = 0;
		for (int i=0; i<numUsuario; i++) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
			if (num >=10) {
				suma +=num;
			}
			
		}
		System.out.println("La suma de los números mayores de 10 que ha introducido es usuario es de "+ suma);
	}

}
