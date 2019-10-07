package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio01_sumaMayor10 {

	public static void main(String[] args) {
	int suma = 0;
	
	//pedimos números al usuario
	for (int i=0; i<4; i++) {
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
		if (num >=10) {
			suma +=num;
		}
	}
	//mostramos resultados al usuario
	System.out.println("La suma de los números mayores de 10 es " + suma);
	}
}
