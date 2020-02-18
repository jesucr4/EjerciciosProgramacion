package tema6_Recursos_Bloque2;

public class Ejercicio05_PrimerosMaximos {


	public static void main (String args[]) {
		
		double ant2 = 0, ant = 0, actual = 0;
		double x = 0;
		for (int i = 0; i < 5; i++) {
			do {
				ant2 = ant;
				ant = actual;
				actual = x * Math.sin(x);
				x += 0.001;
			} while (!(ant > actual && ant > ant2));
			System.out.println("x: " + x + " - y: " + actual + " - y ant: " + ant + " - y ant2: " + ant2);
		}
	}
}
