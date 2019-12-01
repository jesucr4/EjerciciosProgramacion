package tema4_OrientaciónaObjetos_Bloque3_Ejercicio07_Rectangulo.copy³naObjetos_Bloque3_Ejercicio07_Rectangulo;

public class Rectangulo {
		private int alto;
		private int ancho;
		/**
		 * 
		 * @param alto
		 * @param ancho
		 */
		public Rectangulo(int alto, int ancho) {
			
			this.alto = alto;
			this.ancho = ancho;
		}
		

		
		public void imprimir ()	{
			for (int i = 0; i < this.alto; i++) {				
				for (int j = 0; j < this.ancho; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		
}
