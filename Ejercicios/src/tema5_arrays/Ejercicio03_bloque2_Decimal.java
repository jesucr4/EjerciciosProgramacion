package tema5_arrays;

public class Ejercicio03_bloque2_Decimal {

	public static void main(String[] args) {
		float array[] = new float[20];
		int contador = 0;
		
		for (int i  = 0; i < array.length; i++) {
			array[i] = dameNumeroDecimal();
			System.out.print(array[i] + "\t");
			float parteDecimal = array[i] % 1;
			if (parteDecimal < 0.5) {
				contador++;
			}
		}
		
		System.out.println("\nContador: " + contador);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static float dameNumeroDecimal () {
		int parteEntera = (int) Math.round(Math.random() * 100);
		float parteDecimal = (float) Math.random();
		return (parteEntera + parteDecimal);
	}

}
