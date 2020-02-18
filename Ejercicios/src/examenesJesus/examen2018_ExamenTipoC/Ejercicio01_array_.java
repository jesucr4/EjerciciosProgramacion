package examen2018_ExamenTipoC;

public class Ejercicio01_array_ {

	public static void main(String[] args) {
		
		//creamos array y lo inicializamos con bucle for
		int array[]= new int [10];
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) (Math.round(Math.random()*(100-0))+0);
		}
		//creamos variables con las que vamos a trabajar
				int suma = 0, media = 0, mayor = array[0], menor = array[0];
		//mostramos array en pantalla
		System.out.println("Contenido del array");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		//procedemos a realizar operación de suma y cálculo de media y 
		for (int i = 0; i < array.length; i++) {
			suma += array[i];
			media++;
			//buscamos número mayor y menor de los mostrados en el array
			mayor = (array[i] > mayor)? array[i] : mayor;
			menor = (array[i] < menor)? array[i] : menor;
		}
		System.out.println("La suma de los números vistos en el array es " + suma +
				"\n la media de los números del array es " + (suma/media) +
				"\n el mayor de los números es " + mayor + " y el menor es " + menor);
	}
}


