package tema5_arrays;

public class EjercicioBurbuja_Arrays {

	public static void main(String[] args) {
		//creamos e inicializamos array
		int array[] = Utils.creaArrayNumerosAzar(150, 0, 1000);
		Utils.mostrarArray(array);
		//creamos variable auxiliar para guardar número menor que el anterior
		int aux;
		//creamos variable boolean para realizar bucle do while
		//boolean superiorNumeroPosterior = true;
		
		//do {
			for (int i = 0; i < array.length-1; i++) {
				for (int j = 0; j < array.length-2; j++) {
						if (array[j] > array [j+1]) {
							aux = array [j+1];
							array[j+1] = array[j];
							array [j] = aux;
					}
				}
			}
		
			
					
		//}while (superiorNumeroPosterior);
		
		
		Utils.mostrarArray(array);

	}
}
