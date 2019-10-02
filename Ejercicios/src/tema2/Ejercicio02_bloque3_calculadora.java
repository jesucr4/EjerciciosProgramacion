package tema2;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque3_calculadora {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca número entre 1 y 3");
		int num = Integer.parseInt(str);
		
		switch (num) {
			case 1: 
				str = JOptionPane.showInputDialog("Introduzca número para raíz cuadrada");
				float num1 = Float.parseFloat(str);
				
		}
	}

}
