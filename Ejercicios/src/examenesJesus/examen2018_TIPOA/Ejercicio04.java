package examen2018_TIPOA;

import tema5_arrays.Utils;

public class Ejercicio04 {

	public static void main(String[] args) {
		//creamos array y lo inicializamos
		int array []= Utils.creaArrayNumerosAzar(5, 0, 100);
		//mostramos array en pantalla
		Utils.mostrarArray(array);
		//introducimos salto línea para separar array del array que vamos a crear con otro orden
		for (int i = 0; i < array.length * 2; i++) {
			int i1, i2;
			i1 = Utils.obtenerNumeroAzar(0, array.length-1);	
			i2 = Utils.obtenerNumeroAzar(0, array.length-1);
			//creamos variable aux para guardar valores que vamos a intercambiar
			int aux = array[i1];
			array [i1] = array[i2];
			array [i2] = aux;
		}
			Utils.mostrarArray(array);
			
		

	}

}
