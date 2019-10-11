package tema3_bucles;

import javax.swing.JOptionPane;

public class EjercicioFactorial {

	public static void main(String[] args) {
		int factorial = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número para saber su factorial"));;
		
		for (int i=factorial-1 ;i>1; i--) {
			factorial = (i * factorial);
			
		}
		System.out.println("El factorial es " + factorial);
	}

}
