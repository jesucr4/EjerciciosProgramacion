package examen2018_TIPOA.copy;

import tema5_arrays.Utils;

public class Ejercicio03 {

	public static void main(String[] args) {
		int array [] = new int [20];
		int aux;
		
		for (int i = 0; i < array.length; i++) {
			boolean esPar;
			do{
				 aux = (int) (Math.round(Math.random()*(100-25))+25);
				esPar = false;
				for (int j = 0; j < i; j++) {
					if ((aux % 2 == 1)) {
						esPar = true;
					}
			
				}
			}while (esPar);
			array[i] = aux;
		}
		System.out.println();
		Utils.mostrarArray(array);
		
	}
}


