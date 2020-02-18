package examen2018_ExamenTipoB.copy;

import tema5_arrays.Utils;

public class Ejercicio02 {

	public static void main(String[] args) {
		//Mediante un método obtenemos número aleatorio
		// lo introducimos en una variable
		int num = 3 ;//Utils.obtenerNumeroAleatorio();
		//mediante un condicional if vemos si es o no 
		//número primo
		if (num % num == 0 && num % 1 == num) {
			System.out.println("El número " + num + "es primo");
		}else {
			System.out.println("El número" + num + " NO es primo");
		}

	}

}
