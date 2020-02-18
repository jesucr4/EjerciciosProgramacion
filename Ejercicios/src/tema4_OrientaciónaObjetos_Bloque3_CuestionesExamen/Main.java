package tema4_Orientaci�naObjetos_Bloque3_CuestionesExamen;

public class Main {


	public static void main(String[] args) {
		Cuestion cuestiones [] = new Cuestion [4];
		int contadorRespuestasAcertadas = 0;
		
		cuestiones[0] = new VerFal("El campe�n de la champions es el Liverpool", 1);
		cuestiones[1] = new OpcionCorrecta("Actual bal�n de oro", 4, new String [] {"Mbapp�", "Man�", "CR7", "Messi"});
		cuestiones[2] = new VerFal ("Sevilla es una ciudad vasca", 2);
		cuestiones [3] = new VerFal ("Madrid es la capital de Espa�a", 1);
		
		for (int i = 0; i < cuestiones.length; i++) {
			if (cuestiones[i].esCorrecta(cuestiones[i].mostrarEnPantalla())) {
				System.out.println("Acertaste");
				contadorRespuestasAcertadas++;
			}
			else {
				System.out.println("Fallaste");
			}
		}
		System.out.println("Respuestas acertadas: " + contadorRespuestasAcertadas);
	}
}
