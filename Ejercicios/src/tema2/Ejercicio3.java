package tema2;

import javax.swing.JOptionPane;

public class Ejercicio3 {

	public static void main(String[] args) {
		numeroMayor();

	}
	
	public static void numeroMayor () {
		String str = JOptionPane.showInputDialog("Introduce primer número");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduce segundo número");
		int num2 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduce tercer número");
		int num3 = Integer.parseInt(str);
		
		if (num1 > num2) {
			if (num1 > num3) {
				System.out.println("El número mayor es el " + num1);
			}
			else { 
				System.out.println("El número mayor es el " + num3);
			}
		}
		if (num2 > num3) {
				System.out.println("El número mayor es el " + num2);
								
			}
			else {
				System.out.println("El número mayor es el " + num3);
			}
			
		}
}

