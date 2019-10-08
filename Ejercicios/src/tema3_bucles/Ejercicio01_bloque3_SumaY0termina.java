package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio01_bloque3_SumaY0termina {

	public static void main(String[] args) {
		int num = 0;
		
		for (; num!=0; ) {
			Integer.parseInt(JOptionPane.showInputDialog("Introduzca números para realizar suma:\n"
					+ "Para terminar introduzca: 0"));
		}
				
		
	}

}
