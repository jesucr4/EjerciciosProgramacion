package tema2;

import javax.swing.JOptionPane;

public class Ejercicio2b_mayor {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca primer n�mero");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduca segundo n�mero");
		int num2 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca tercer n�mero");
		int num3 = Integer.parseInt(str);
		
		if (num1 == num2 && num2 == num3) {
			System.out.println("Los tres n�meros son iguales");
		}
		else {
			if(num1>num2 && num2>num3) {
				System.out.println("El n�mero mayor es " + num1);
			}
			else {
				if (num2>num1 && num2>num3) {
					System.out.println("El n�mero mayor es " + num2);
				}
				else {
					System.out.println("El n�mero mayor es " + num3);
				}
			}
		}
	}
}
