package tema5_arrays;

import javax.swing.JOptionPane;

public class Ejercicio01_LimInf_LimSup_Usuario {

	public static void main(String[] args) {
		//pedimos al usuario límite superior y límite inferior del array
		int limInf = Integer.parseInt(JOptionPane.showInputDialog("Introduzca límite inferior del array"));
		int limSup = Integer.parseInt(JOptionPane.showInputDialog("Introduzca límite superior del array"));
		
		int array[]=new int [150];
		for (int i = 0; i < array.length; i++) {
			array[i]= Utils.obtenerNumeroAleatorio(limInf, limSup);
		}
		Utils.mostrarArray(array);
	}

}
