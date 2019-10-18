package tema5_arrays;

public class Ejercicio02_array_Inverso {

	public static void main(String[] args) {
		int array[]= Utils.creaArrayNumerosAzar(150, 0, 100);
		Utils.mostrarArray(array);
		
		System.out.println();
		for (int i = array.length -1; i>-1; i--) {
			System.out.print( array[i] + " ");
		}
		
		
	}

}
