package tema5_arrays;

public class EjercicioSelección_array {

	public static void main(String[] args) {
		//creamos, inicializamos y mostramos array
		int array[] = Utils.creaArrayNumerosAzar(5, 0, 1000);
		Utils.mostrarArray(array);
		//creamos variable menor y variable auxiliar para guardar número
		int menor;
		int aux = 0;
		for (int i = 0; i < array.length-1; i++) {
			menor = array[i];
			for (int j = i+1; j < array.length-2; j++) {
				if(array[j]< menor) {
					array[j] = menor;
					aux = array[i];
					menor = aux;
					
				}
			}
		}
		Utils.mostrarArray(array);
	}

}
