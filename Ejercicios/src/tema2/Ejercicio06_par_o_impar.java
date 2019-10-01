package tema2;

import javax.swing.JOptionPane;

public class Ejercicio06_par_o_impar {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca número");
		int num1 = Integer.parseInt(str);
		
		if ( num1 % 2 == 1) {
			System.out.println("El número introducido es impar");
		}
		else {
			System.out.println("El número introducido es par");
		}

	}

}
