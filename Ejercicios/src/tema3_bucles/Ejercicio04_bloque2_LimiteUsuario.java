package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio04_bloque2_LimiteUsuario {

	public static void main(String[] args) {
		//pedimos al usuario que nos indique múltiplo y el número límite hasta que quiere saber sus múltiplos
		int multiplo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número del que quiera saber sus múltiplos"));
		int limite = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número límite hasta el que quiera saber múltiplos"));
		
		for (int i = 0; i < limite; i+=multiplo) {
			
			System.out.println(i + " es múltiplo de " + multiplo + " hasta el número " + limite + 
					" que el usuario ha introducido");
		}
	}

}
