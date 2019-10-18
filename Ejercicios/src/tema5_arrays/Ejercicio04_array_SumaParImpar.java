package tema5_arrays;

public class Ejercicio04_array_SumaParImpar {

	public static void main(String[] args) {
		//creamos variables para sumar numeros pares e impares
		int sumPar = 0, sumImpar= 0;
		//creamos array y mostramos
		int array[]= Utils.creaArrayNumerosAzar(5, 0, 10);
		Utils.mostrarArray(array);
		System.out.println();
		//realizamos operación de suma de números
		for (int i = 0; i < array.length; i++) {
			if (array[i]%2==0) {
				sumPar +=array[i];
			}else {
				sumImpar +=array[i];
			}
		}
		System.out.println("La suma de los números pares es " + sumPar + "\nla suma de los impares es " + sumImpar);
	}

}
