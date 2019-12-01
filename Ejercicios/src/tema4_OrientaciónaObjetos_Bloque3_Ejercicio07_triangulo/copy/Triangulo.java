package tema4_OrientaciónaObjetos_Bloque3_Ejercicio07_triangulo.copy³naObjetos_Bloque3_Ejercicio07_triangulo;

public class Triangulo {
		private int alto;
		private int ancho;
		/**
		 * 
		 * @param alto
		 * @param ancho
		 */
		public Triangulo(int alto, int ancho) {
			super();
			this.alto = alto;
			this.ancho = ancho;
		}
		

		
		
		public void imprimir ()	{
			int contadorAsteriscosPorFila = 1;
			for (int i = 0; i < this.alto; i++) {	
				for (int j = 0; j < contadorAsteriscosPorFila; j++) {
					System.out.print("*");
				}
				contadorAsteriscosPorFila++;
				System.out.println();
			}
		}
		
		
}
