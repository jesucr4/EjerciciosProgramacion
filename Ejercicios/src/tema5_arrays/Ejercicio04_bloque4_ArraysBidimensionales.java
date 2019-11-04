package tema5_arrays;

public class Ejercicio04_bloque4_ArraysBidimensionales {

	public static void main(String[] args) {
		//llamamos al método rellena matriz para crear e inicializar un array bidimensional
		int array [][]=new int [5][5];
		rellenaMatriz(array);
		mostrarMatriz(array);
		
		

	}
	
	/**
	 * 
	 * @param array
	 * @param min
	 * @param max
	 */
	private static void rellenaMatriz(int [][] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.obtenerNumeroAleatorio();
			for (int j = 0; j < array.length; j++) {
				array[j]= Utils.obtenerNumeroAleatorio();
			}
		}		
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	private static int[][] mostrarMatriz (int[][] array) {
		System.out.println("Contenido del array bidimensional");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + "");
			for (int j = 0; j < array.length; j++) {
				System.out.println(array[j]+ "");
			}
		}
		return array;
		
	}
	



}
