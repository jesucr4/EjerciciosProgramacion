package examen2018_ExamenTipoB.copy;

public class Ejercicio03 {

	public static void main(String[] args) {
		int array [] = new int [20];
		
		
		for (int i = 0; i < array.length; i++) {
			int aux = (int) (Math.round(Math.random()*(100-25))+25);
			if ((aux %2 ==0)) {
				array[i]=aux;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
