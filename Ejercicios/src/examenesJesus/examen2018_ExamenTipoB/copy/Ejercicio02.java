package examen2018_ExamenTipoB.copy;

import tema5_arrays.Utils;

public class Ejercicio02 {

	public static void main(String[] args) {
		//Mediante un m�todo obtenemos n�mero aleatorio
		// lo introducimos en una variable
		int num = 3 ;//Utils.obtenerNumeroAleatorio();
		//mediante un condicional if vemos si es o no 
		//n�mero primo
		if (num % num == 0 && num % 1 == num) {
			System.out.println("El n�mero " + num + "es primo");
		}else {
			System.out.println("El n�mero" + num + " NO es primo");
		}

	}

}
