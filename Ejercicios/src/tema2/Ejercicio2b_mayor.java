package tema2;

import javax.swing.JOptionPane;

public class Ejercicio2b_mayor {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca primer número");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduca segundo número");
		int num2 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca tercer número");
		int num3 = Integer.parseInt(str);
		
		if (num1 == num2 && num2 == num3) {
			System.out.println("Los tres números son iguales");
		}
		else {
			if(num1>num2 && num2>num3) {
				System.out.println("El número mayor es " + num1);
			}
			else {
				if (num2>num1 && num2>num3) {
					System.out.println("El número mayor es " + num2);
				}
				else {
					System.out.println("El número mayor es " + num3);
				}
			}
		}
	}
}
