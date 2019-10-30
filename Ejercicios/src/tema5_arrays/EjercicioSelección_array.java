package tema5_arrays;

public class EjercicioSelección_array {

	public static void main(String[] args) {
		//creamos, inicializamos y mostramos array
		int array[] = Utils.creaArrayNumerosAzar(150, 0, 1000);
		Utils.mostrarArray(array);
		//creamos variable menor y variables i y j para bucle y variable auxiliar para guardar número
		int i,j, aux;
		int menor = 0;
		//creamos bucle for
		for (i = 0; i < array.length-1; i++) {
			menor= i;
			for (j = i+1; j < array.length; j++) {
				if (array[j]<array[menor]) {
					menor = j;
					aux = array[i];
					array [i] = array[menor];
					array[menor]= aux;
					
				}
				
			}
			
		}
		Utils.mostrarArray(array);
	}

}
