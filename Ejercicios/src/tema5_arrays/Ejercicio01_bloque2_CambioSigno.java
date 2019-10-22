package tema5_arrays;

public class Ejercicio01_bloque2_CambioSigno {

	public static void main(String[] args) {
		//creamos array y lo mostramos en pantalla
		int array[] = Utils.creaArrayNumerosAzar(150, -100, 100);
		Utils.mostrarArray(array);
		//hacemos salto de línea
		System.out.println();
		//realizamos bucle for para cambiar signo a los números que sean pares
		for (int i = 0; i < array.length; i++) {
			if (array[i]%2 ==0 ) {
				System.out.println(array[i]*(-1));  //array[i] *=-1
			}
		}
		
	}

}
