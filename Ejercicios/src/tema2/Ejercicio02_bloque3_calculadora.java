package tema2;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque3_calculadora {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca número entre 1 y 3 para elegir opción:\n\n"
				+ "1.-Raíz cuadrada\n"
				+ "2.-Potencia\n"
				+ "3.-Módulo");
		int num = Integer.parseInt(str);
		
		switch (num) {
			case 1: //raíz cuadrada
				str = JOptionPane.showInputDialog("Introduzca número para cálculo de raíz cuadrada");
				float num1 = Float.parseFloat(str);
				
				//cálculo de la raíz
				float num2 = ((float) Math.sqrt(num1));
				System.out.println("La ra�z cuadrada del n�mero introducido es " + num2);
				break;
			case 2: //potencia
				str = JOptionPane.showInputDialog("Introduzca n�mero base para potencia");
				float numBase = Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduzca n�mero para exponente potencia");
				float numExponente = Float.parseFloat(str);
				//cálculo de la potencia
				float potencia = (float) Math.pow(numBase, numExponente);
				System.out.println("El resultado de la potencia introducida es " + potencia);
				break;
			case 3: //módulo de división
				str = JOptionPane.showInputDialog("Introduzca n�mero para dividendo");
				float dividendo = Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduzca n�mero para divisor");
				int divisor = Integer.parseInt(str);
				//cálculo de división
				float division = (dividendo % divisor);
				System.out.println("El resto de la divisi�n introducida es " + division);
				break;
				default:
				System.out.println("El n�mero introducido no conlleva ninguna operaci�n");
					
				
		}
	}

}
