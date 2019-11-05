package tema5_arrays;

public class Ejercicio04_bloque4_ArraysBidimensionales {

	public static void main(String[] args) {
		//llamamos al m�todo rellena matriz para crear e inicializar un array bidimensional
		int matriz [][]=new int [5][5];
		rellenaMatriz(matriz, -100, 100);
		mostrarMatriz(matriz);
		
		

	}
	
	/**
	 * 
	 * @param array
	 * @param min
	 * @param max
	 */
	private static void rellenaMatriz(int matriz [][], int min, int max) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i] [j] = Utils.obtenerNumeroAzar(min, max);
				
			}
		}		
	}
	/**
	 * 
	 * @param array
	 */
	private static void mostrarMatriz (int matriz [][]) {
		System.out.println("Contenido del array bidimensional");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i] [j] + " ");
			}
			System.out.println();
		}
		
		
	}
	



}
