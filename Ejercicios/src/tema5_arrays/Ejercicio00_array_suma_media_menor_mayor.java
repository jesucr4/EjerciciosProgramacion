package tema5_arrays;

public class Ejercicio00_array_suma_media_menor_mayor {

	public static void main(String[] args) {
		float suma = 0, mayor = 0, menor = 0;
		int media = 0;
		int numeros[]= Utils.creaArrayNumerosAzar(5, 0, 10);
		Utils.mostrarArray(numeros);
		
		System.out.println();
		
		for (int i = 0; i<numeros.length; i++) {
			suma +=numeros[i];
			media = (int) (suma/numeros.length);
			if (i==0) {
				mayor= numeros[i];
				menor= mayor;
			}else {
				if (numeros[i]>mayor) {
					mayor = numeros[i];
				}else {
					menor = numeros [i];
				}
				
			}
		}
			
		
		System.out.println("La suma de los número es " + suma + "\n la media es " + media + 
				"\n el mayor es " + mayor + "\n el menor es " + menor);
		
			
		

	
	}
}
