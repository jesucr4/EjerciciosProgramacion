package examen2018_ExamenTipoC;

import tema5_arrays.Utils;

public class Ejercicio02_99_a_0 {

	public static void main(String[] args) {
		int array[]=new int [100];
		//creamos contador empezando en el 99 para realizar bucle for
		int cont = 99;
		//realizamos bucle for
		for (int i = 0; i < array.length; i++) {
			array[i]=cont;
			cont--;
		}
		Utils.mostrarArray(array);

	}

}
