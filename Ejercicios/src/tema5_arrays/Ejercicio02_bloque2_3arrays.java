package tema5_arrays;

public class Ejercicio02_bloque2_3arrays {

	public static void main(String[] args) {
		//creamos variables número par y número impar
		
		//creamos primer array y mostramos en pantalla
		int primerArray[]= Utils.creaArrayNumerosAzar(5, 0, 10);
		Utils.mostrarArray(primerArray);
		//introducimos salto de línea entre primer y segundo array
		System.out.println();
		//creamos segundo array y lo mostramos en consola
		int segundoArray[]= Utils.creaArrayNumerosAzar(5, 0, 10);
		Utils.mostrarArray(segundoArray);
		//introducimos salto de línea entre segundo y tercer array
		System.out.println();
		//creamos tercer array
		int tercerArray[]= new int[5];
		
		for (int i = 0; i < primerArray.length; i++) {
			if (i%2 == 1) {
				int impar = i;
				for (int j = 0; j < tercerArray.length; j++) {
					if (j%2 == 1) {
						tercerArray[j]=impar;
					}
				}
				
			}
		}
		
		for ( int i = 0; i < segundoArray.length; i++) {
			if (i%2 == 0) {
				int par = i;
				for (int j = 0; j < tercerArray.length; j++) {
					if (j%2 == 0) {
					 tercerArray[j] = par;
					}
				}
			}
		}
		Utils.mostrarArray(tercerArray);
		}
		
}


