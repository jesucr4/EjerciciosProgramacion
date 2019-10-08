package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio01_bloque3_SumaY0termina {

	public static void main(String[] args) {
		//declaramos variables que vamos a usar posteriormente en el bucle y para realizar la suma de los números
		int num = 1;
		int suma = 0;
		// realizamos bucle for, para que se siga repitiendo pedimos que el valor de la variable num sea siempre diferente a 0
		//pediremos a usuario que introduzca números para realizar suma, así como le permitiremos terminar con la operación
		for (int i ; num!=0; i++) {
		 i = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número para realizar suma\n" + 
		"Introduzca para terminar operación: 0"));
		 //realizamos operación de suma asignando cada valor que vaya introduciendo el usuario a i
		 suma +=i;
		 //declaramos condición para terminar con el bucle, será cuando el valor introducido por el usuario sea igual a cero
		 //mostraremos mensaje en pantalla.
		 if (i == 0) {
			 System.out.println("La suma total de los números introducidos es "+ suma);
			 return;
		 
		
		}
				
		
		}
	}
}

