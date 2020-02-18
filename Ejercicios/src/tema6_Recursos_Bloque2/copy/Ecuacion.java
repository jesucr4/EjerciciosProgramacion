package tema6_Recursos_Bloque2.copy;

import javax.swing.JOptionPane;

public class Ecuacion {

	public static void main(String[] args) {
		//variable x 
		int xpositiva;
		int xnegativa;
		
		
		
		// pedimos al usuario las tres variables de la ecuación
		int a = Integer.parseInt(JOptionPane.showInputDialog("Introduzca variable a de la ecuación de segundo grado"));
		int b = Integer.parseInt(JOptionPane.showInputDialog("Introduzca variable b de la ecuación de segundo grado"));
		int c = Integer.parseInt(JOptionPane.showInputDialog("Introduzca variable c de la ecuación de segundo grado"));
		
		xpositiva = (int) ((-b -(Math.sqrt(Math.pow(b, 2)-(4*a*c)))) / 2*a);
		xnegativa = (int) ((-b +(Math.sqrt(Math.pow(b, 2)-(4*a*c)))) / 2*a);
		
		System.out.println(" El valor de la x positiva es " + xpositiva);
		System.out.println(" El valor de la x negativa es " + xnegativa);
		
		int ecuacionXpos = (int) ( a *(Math.pow(xpositiva, 2)) + b*xpositiva + c);
		
		
		int ecuacionXneg = (int) ( a *(Math.pow(xnegativa, 2))  + b*xnegativa + c);
		
		System.out.println("El resultado de cambiar la x por ambas soluciones anteriores es: \n" + ecuacionXpos 
				+ "\n" + ecuacionXneg);
	}

}
