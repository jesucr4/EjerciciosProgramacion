

public class Ejercicio01_suma_media_m�ximo_m�nimo{

	public static void main(String[] args) {
		
		//creamos array y lo inicializamos dandole valores al
		//azar haciendo uso de un método
		int array []= Utils.creaArrayNumerosAzar(100, 0, 100);
		//mostramos array en pantalla a través de otro método
		Utils.mostrarArray(array);
		System.out.println();
		//creamos variables de suma, media, máximo y mínimo
		int suma = 0,  maximo = array[0], minimo=array[0];
		float media = 0;
		//realizamos bucle for para recorrer array e ir realizando operaciones
		for (int i = 0; i < array.length; i++) {
			//en la variable suma vamos sumando cada uno de los valores del array
			suma += array[i];
			//usamos la variable media como si fuese un contador para después dividir la suma entre el total de números que tenemos en el array
			media++;
			//buscamos número máximo y mínimo de los mostrados en el array
			maximo = (array[i] > maximo)? array[i] : maximo;
			minimo = (array[i] < minimo)? array[i] : minimo;
		}
		//imprimimos en pantalla los diferentes calculos que se nos pide	
		System.out.println(" La suma de los números vistos en el array es " + suma +
				"\n la media de los números del array es " + (suma/media) +
				"\n el mayor de los números es " + maximo + " y el menor es " + minimo);
		}
		
}


