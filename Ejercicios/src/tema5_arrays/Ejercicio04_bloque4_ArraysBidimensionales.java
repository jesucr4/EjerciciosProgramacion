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
		boolean esDiagonal = matrizDiagonal(matriz);
		if (esDiagonal) {
			System.out.println("La matriz es DIAGONAL");
		}
		else {
			System.out.println("La matriz NO ES DIAGONAL");
		}
		matrizTriangularSuperior(matriz);
		matrizTraspuesta(matriz);
		matrizOpouesta(matriz);
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
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean matrizDiagonal (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j=+6) {
				if (matriz[i][j] != 0) { 
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * 
	 * @param matriz
	 */
	private static void matrizTriangularSuperior (int matriz[][]) {
		int suma = 0;
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (j<i) {
					suma+=matriz[i][j];
				}
			}
		}
		if(suma==0) {
			System.out.println("La matriz ES TRIANGULAR SUPERIOR");
		}else {
			System.out.println("La matriz NO ES TRIANGULAR SUPERIOR");
		}
	}
	
	private static void matrizDifusa (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
			}
		}
	}
	
	private static void matrizTraspuesta (int matriz[][]) {
		int aux []= new int [5];
		
		for ( int i = 0; i < matriz.length; i++) {
			for ( int j = 0; j < matriz[i].length; j++) {
				 aux = matriz [i];
				 matriz[i] = matriz [j];
				 matriz [j] = aux;
				 System.out.print(matriz[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}
	
	private static void matrizOpouesta (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]*(-1) + " ");
			}
			System.out.println();
		}
	}
	



}
