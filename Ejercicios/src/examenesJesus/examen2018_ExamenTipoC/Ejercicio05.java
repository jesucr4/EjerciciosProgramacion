package examen2018_ExamenTipoC;

import tema5_arrays.Utils;

public class Ejercicio05 {

	public static void main(String[] args) {
		//creamos array e inicializamos
		int array[]= new int [20];
		
		for (int i = 0; i < array.length; i++) {
			//declaramos variable auxiliar 
			int numero;
			// creamos variable booleana que nos va a servir para comprobar si nuestro 
			//número ya está en el array
			boolean existeNumeroEnArray;
			do {
				numero = Utils.obtenerNumeroAzar(20, 40);
				//ponemos varibale booleana en falso para que se realice bucle
				existeNumeroEnArray = false;
				for (int j = 0; j < i; j++) {
					// si el número que está en el array es igual al primer número dado
					//indicamos en la variable booleana que es así para que de el salto 
					//hacia arriba y vuelva a realizar el segundo bucle for
					if (array[j] == numero) {
						existeNumeroEnArray = true;
					}
				}
				//comprobado que no existe el número en el array se introduce en 
				//la variable numero creada y se vuelve a realizar la misma operación
			}while (existeNumeroEnArray );
			array[i] = numero;
		}
		System.out.println();
		Utils.mostrarArray(array);

	}

}
