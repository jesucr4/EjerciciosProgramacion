package examen2018_ExamenTipoB;

import tema5_arrays.Utils;

public class Ejercicio05_fibonacci {

	public static void main(String[] args) {
		int array [] = new int [100];
		array[0] = 1;
		array [1] = 1;
		for (int i = 2; i < array.length-1; i++) {
			array[i] = array[i-2] + array[i-1];
		}
		Utils.mostrarArray(array);
	}

}
