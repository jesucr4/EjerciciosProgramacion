package tema2;

import javax.swing.JOptionPane;

public class Ejercicio2_menor {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca primer n�mero");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca segundo n�mero");
		int num2 = Integer.parseInt(str);
		
		if (num1 > num2) {
			System.out.println(num2 + " es el n�mero menor");
		}
		else {
			if (num2 > num1) {
				System.out.println(num1 + " es el n�mero menor");
			}
			else {
				System.out.println("Los dos n�meros son iguales");
			}
		}


	}

}
