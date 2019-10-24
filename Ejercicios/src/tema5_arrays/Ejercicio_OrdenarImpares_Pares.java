package tema5_arrays;

public class Ejercicio_OrdenarImpares_Pares {

	public static void main(String[] args) {
		// Declaro un array de n�meros al azar
				int array[] = Utils.creaArrayNumerosAzar(10, 0, 9);
				
				// Mostrar array original
				Utils.mostrarArray(array);
				
				// Creo un array auxiliar que contendr� a los n�meros impares
				int impares[] = new int[array.length];
				
				// Recorro el array original, buscando y almacenando n�meros impares en el array "impares"
				int indiceArrayImpares = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i] % 2 == 1) { // Impar, debe ir al array "impares"
						impares[indiceArrayImpares] = array[i];
						indiceArrayImpares++;	
								}
					}
						
				
				}
				
				// Mostrar el array de impares
				Utils.mostrarArray(impares);
				
	}
				
}			
					
					
					
				
	


