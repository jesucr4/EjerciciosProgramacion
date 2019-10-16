package tema5_arrays_bloque01;

public class Ejercicio01_array_suma_media_menor_mayor {

	public static void main(String[] args) {
		int numeros[]= new int[150];
		
		//inicializamos el contenido de array
		for (int i=0; i<numeros.length; i++) {
			numeros[i]= numeroAleatorio();
			
		}
			
		for (int i= 0; i< numeros.length; i++) {
			System.out.println(numeros[i]+ "");
			}
		
			System.out.println();
			
			
		}

	
	public static int numeroAleatorio () {
		 return (int) Math.round(Math.random() * 100);
	}
}
