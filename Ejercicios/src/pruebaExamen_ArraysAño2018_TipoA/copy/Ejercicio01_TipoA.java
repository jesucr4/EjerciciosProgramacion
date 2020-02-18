package pruebaExamen_ArraysAÒo2018_TipoA.copy±o2018_TipoA;

public class Ejercicio01_TipoA {

	public static void main(String[] args) {
		int suma = 0, media = 0, mayor, menor;
		
		//creamos array de n√∫meros enteros y le asignamos valores al azar.
		int array[] = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.round(Math.random()*(1000-0))+0);
		}
		//mostramos contenido del array en pantalla
		System.out.println("Contenido del array");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		//volvemos a realizar bucle for para realizar diferentes operaciones que se nos pide
		
		
		

	}

}
