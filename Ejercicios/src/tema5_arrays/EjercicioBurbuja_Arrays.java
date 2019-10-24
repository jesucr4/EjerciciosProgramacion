package tema5_arrays;

public class EjercicioBurbuja_Arrays {

	public static void main(String[] args) {
		//creamos e inicializamos array
		int array[] = Utils.creaArrayNumerosAzar(05, 0, 1000);
		Utils.mostrarArray(array);
		//creamos variable auxiliar para guardar número menor que el anterior
		int aux;
		//creamos variable boolean para realizar bucle do while
		boolean superiorNumeroPosterior = true;
		
		do {
			for (int i = 0; i < array.length-1; i++) {
				if (array[i] > array [i+1]) {
					aux = array [i+1];
					array[i+1] = array[i];
					array [i] = aux;	
				}else {
					for (i = 0; i < array.length-1; i++) {
						if (array[i] > array [i+1]) {
							aux = array [i+1];
							array[i+1] = array[i];
							array [i] = aux;
					}
				}
			}
				Utils.mostrarArray(array);
			
			superiorNumeroPosterior = false;
		
			}
		}while (superiorNumeroPosterior);
		Utils.mostrarArray(array);
		
	

	}
}
