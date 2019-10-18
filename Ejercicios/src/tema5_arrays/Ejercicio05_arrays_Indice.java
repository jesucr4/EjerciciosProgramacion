package tema5_arrays;

public class Ejercicio05_arrays_Indice {

	public static void main(String[] args) {
		
		//creamos variable para sumar números cuyo índice sea par
		//creamos array e inicializamos
		int sumPar = 0;
		int array[]=Utils.creaArrayNumerosAzar(150, 0, 100);
		Utils.mostrarArray(array);
		System.out.println();
		//realizamos bucle for para ver en que posición están los números y realizar suma de los que su índice sea par
		for (int i = 0; i < array.length; i++) {
			if (i%2==0) {
				sumPar+=array[i];
			}
		}
		System.out.println(sumPar);
	}

}
