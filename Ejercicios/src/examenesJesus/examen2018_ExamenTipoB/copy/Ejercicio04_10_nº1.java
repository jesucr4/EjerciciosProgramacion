package examen2018_ExamenTipoB.copy;

import tema5_arrays.Utils;

public class Ejercicio04_10_nº1 {

	public static void main(String[] args) {
		//creamos array de 100 elementos 
		int array[] = new int [100];
		for (int i = 0; i < array.length; i++) {
		}
		Utils.mostrarArray(array);
		int array10[]= new int [10];
		
		for (int i = 0; i < array10.length; i++) {
			array[i]= 1;
		}
		Utils.mostrarArray(array10);
		for (int i = 0; i < array.length; i++) {
			
		}
	}

}
