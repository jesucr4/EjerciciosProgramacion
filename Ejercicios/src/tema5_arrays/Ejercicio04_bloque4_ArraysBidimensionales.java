package tema5_arrays;

public class Ejercicio04_bloque4_ArraysBidimensionales {

	public static void main(String[] args) {
		//llamamos al método rellena matriz para crear e inicializar un array bidimensional
		int matriz [][]=new int [5][5];
		rellenaMatriz(matriz, -100, 100);
		mostrarMatriz(matriz);
		//llamamos a método para comprobar si la raíz es positiva
		matrizPositiva(matriz);
		//método para comprobar si la diagonal es positiva
		comprobarDiagonal(matriz);
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
	/**
	 * 
	 * @param matriz
	 */
	private static void matrizPositiva (int matriz [][]) {
		int i = 0; 
		int j = 0;
		
		for ( i = 0; i < matriz.length-1; i++) {
			for ( j = 0; j < matriz[i].length-1; j++) {
			}
		}
		if ( matriz [i][j] >= 0) {
			System.out.println("La matriz es POSITIVA");
		}else {
			System.out.println("La matriz es NEGATIVA");
		}
		}
		
	private static void comprobarDiagonal(int matriz[][]) {
		int i = 0;
		int j = 0;
		for ( i = 0; i < matriz.length-1; i++) {
			for ( j = 0; j < matriz[i].length-1; j=+6) {
			}
		}
		//if ( matriz [i][j] < 0) {
			//System.out.println("La matriz no es diagonal");
	//	}else {
		//	System.out.println("La matriz  ES DIAGONAL!!!");
		//}
	}
	



}
