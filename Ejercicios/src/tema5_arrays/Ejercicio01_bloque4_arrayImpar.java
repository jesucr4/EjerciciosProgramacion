package tema5_arrays;

public class Ejercicio01_bloque4_arrayImpar {

	public static void main(String[] args) {
		// llamamos al método que queremos para realizar el programa
		arrayImpar();
	}
	
	public static int[] arrayImpar() {
		float media;
		int array[] = new int [Utils.obtenerNumeroAleatorio()];
		for (int i = 0; i < array.length; i++) {
			array[i]= Utils.obtenerNumeroAleatorio(0, 100);
		}
		media = (float)array.length/2f;
			if(array.length % 2 ==1) {
				System.out.println("La longitud del array es -1 " + "su posición media esta en " + media);
			}else {
				System.out.println("La longitud del array es par " + "\nsu posición media esta en " + media);
			}
		
	
		return array;
	}

}
