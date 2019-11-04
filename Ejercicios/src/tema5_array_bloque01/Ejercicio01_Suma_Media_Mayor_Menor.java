package tema5_array_bloque01;

public class Ejercicio01_Suma_Media_Mayor_Menor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//construimos array
		int numeros [] = new int[150];
		
		//inicializamos array
		for (int i=0; i < numeros.length; i++ ) {
			numeros[i]= i+1;
		}
		for (int i=0; i< numeros.length; i++) {
			System.out.println(numeros[i]);
		}
	}

}
