package tema5_arrays;

public class Utils {
	/**
	 * 
	 * @param array
	 */
	public static void mostrarArray (int[] array) {
		System.out.println("Contenido del array");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	/**
	 * 
	 * @param longitud
	 * @param limInf
	 * @param limSup
	 * @return
	 */
	public static int[] creaArrayNumerosAzar (int longitud, int limInf, int limSup) {
		int array[] = new int[longitud];
		for (int i = 0; i < array.length; i++) {
			array[i] = obtenerNumeroAleatorio(limInf, limSup);
		}
		return array;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int obtenerNumeroAleatorio () {
		return (int) Math.round(Math.random() * 100);
	}
	
	/**
	 * 
	 * @return
	 */
	public static int obtenerNumeroAleatorio (int limiteInferior, int limiteSuperior) {
		return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
	}
	
	
	

}
