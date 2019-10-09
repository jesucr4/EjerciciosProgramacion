package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio01_bloque3_SumaY0termina {

	public static void main(String[] args) {
		//declaramos variables que vamos a usar posteriormente en el bucle y para realizar la suma de los n�meros
		int num = 0;
		int suma = 0;
		// realizamos bucle for, para que se siga repitiendo pedimos que el valor de la variable num sea siempre diferente a 0
		//pediremos a usuario que introduzca n�meros para realizar suma, as� como le permitiremos terminar con la operaci�n
		for (int i ; num!=0; i++) {
		 i = Integer.parseInt(JOptionPane.showInputDialog("Introduzca n�mero para realizar suma\n" + 
		"Introduzca para terminar operaci�n: 0"));
		 //realizamos operaci�n de suma asignando cada valor que vaya introduciendo el usuario a i
		 suma +=i;
		 //declaramos condici�n para terminar con el bucle, ser� cuando el valor introducido por el usuario sea igual a cero
		 //mostraremos mensaje en pantalla.
		 if (i == 0) {
			 System.out.println("La suma total de los n�meros introducidos es "+ suma);
			 
		 
		
		}
				
		
		}
	}
}

