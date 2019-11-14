package examen2018_ExamenTipoC;

import tema5_arrays.Utils;

public class Ejercicio3_divisores {

	public static void main(String[] args) {
		int j;
		int array []= Utils.creaArrayNumerosAzar(20, 0, 100);
		Utils.mostrarArray(array);
		
		for (int i = 0; i < array.length; i++) {
			//realizamos otro bucle for para dividir nuestro número entre el resto de números
			//hasta llegar a él mismo
			boolean esDivisordelNumero ;
			do {
				esDivisordelNumero = false;
				for ( j = 0; j <= array[i]; j++) {
					if((array[i] % j) == 0) {
						esDivisordelNumero = true;
					}
			}
				
			}while (esDivisordelNumero);
			System.out.println("El número " + j + " es divisor de " + array[i]);
		}

	}

}
