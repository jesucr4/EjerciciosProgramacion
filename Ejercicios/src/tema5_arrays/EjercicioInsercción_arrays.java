package tema5_arrays;

public class EjercicioInsercción_arrays {

	public static void main(String[] args) {
		//generamos array y lo inicializamos
		int array[]= Utils.creaArrayNumerosAzar(150, 0, 1000);
		int aux;
		int i, j;
		Utils.mostrarArray(array);
		//creamos bucle for para recorrer array
		for ( i = 0; i < array.length; i++) {
			aux = array[i];
			//creamos otro bucle for para realizar iteracciones
			for ( j = i; j >0 && array[j-1]>aux; j--) {
				array[j]= array[j-1];
			}
			array[j] = aux;
		}
		Utils.mostrarArray(array);
	}

}
