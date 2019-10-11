package tema3_bucles;

public class Ejercicio_Intervalo_1000n {

	public static void main(String[] args) {
		obtenerSuma();
		obtenerMedia();
		//obtenerMayor();
		//obtenerMenor();
	}
	public static int obtenerNumeroAzar (int min, int max) {
		 return (int) Math.round(Math.random() * (1000 - 0)) + 0;
	}
	
	public static void obtenerSuma() {
		int num = 0;
		int suma = 0;
		for (int i = 0;  i<1000; i++) {
			num = obtenerNumeroAzar(0, 1000);
			suma +=num;
		}
		System.out.println("La suma de los números obtenidos al azar es " + suma );
	}
	
	public static void obtenerMedia() {
		int num = 0;
		int media = 0;
		int suma = 0;
		for (int i = 0; i<1000; i++) {
			num = obtenerNumeroAzar (0,1000);
			suma +=num;
			media = suma/1000;
		}
		System.out.println("La media de los números introducidos es " + media);
	}
	
}
