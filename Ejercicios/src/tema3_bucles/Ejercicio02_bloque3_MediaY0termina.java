package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque3_MediaY0termina {

	public static void main(String[] args) {
			int num = 1;
			int suma = 0;
			float contMedia = 0;
			for (int i ; num!=0; i++) {
				 i = Integer.parseInt(JOptionPane.showInputDialog("Introduzca n�mero para realizar suma y posterior media\n" + 
				"Introduzca para terminar operaci�n: 0"));
				 			 
				if (i!=0) { 
					contMedia++;
					 suma +=i;
				}else {
					System.out.println("La media de los n�meros introducidos es " + (suma/contMedia));
					
				}
				
				}

	}

}
