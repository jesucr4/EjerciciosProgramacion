package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque3_MediaY0termina {

	public static void main(String[] args) {
			int num = 1;
			int suma = 0;
			float acumMedia = 0;
			for (int i ; num!=0; i++) {
				 i = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número para realizar suma y posterior media\n" + 
				"Introduzca para terminar operación: 0"));
				 			 
				if (i!=0) { 
					acumMedia++;
					 suma +=i;
				}else {
					System.out.println("La media de los números introducidos es " + (suma/acumMedia));
					return;
				}
				
				}

	}

}
