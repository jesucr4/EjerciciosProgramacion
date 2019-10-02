package tema2;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque3_calculadora {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca nÃºmero entre 1 y 3");
		int num = Integer.parseInt(str);
		
		switch (num) {
			case 1: 
				str = JOptionPane.showInputDialog("Introduzca nÃºmero para raÃ­z cuadrada");
				float num1 = Float.parseFloat(str);
				float num2 = ((float) Math.sqrt(num1));
				System.out.println("La raíz cuadrada del número introducid es " + num2);
					break;
			case 2:
				str = JOptionPane.showInputDialog("Introduzca número base para potencia");
				float numBase = Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduzca número para exponente potencia");
				float numExponente = Float.parseFloat(str);
				float potencia = (float) Math.pow(numBase, numExponente);
				System.out.println("El resultado de la potencia introducida es " + potencia);
					break;
			case 3:
				str = JOptionPane.showInputDialog("Introduzca número para dividendo");
				float dividendo = Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduzca número para divisor");
				int divisor = Integer.parseInt(str);
				int division = (int) (dividendo % divisor);
				System.out.println("El resto de la división introducida es " + division);
					break;
				default:
					System.out.println("El número introducido no conlleva ninguna operación");
					
				
		}
	}

}
