package tema2;

import javax.swing.JOptionPane;

public class Ejercicio07_if_and {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = JOptionPane.showInputDialog("Introduzca n�mero:");
		int num1 = Integer.parseInt(str);
		
		if (( num1 & 1) == 1) {
			System.out.println("El n�mero introducido es impar");
		}
		else {
			System.out.println("El n�mero introducido es par");
		}
	}

}
