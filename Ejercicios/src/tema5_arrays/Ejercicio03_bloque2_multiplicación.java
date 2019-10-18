package tema5_arrays;

import javax.swing.JOptionPane;

public class Ejercicio03_bloque2_multiplicación {

	public static void main(String[] args) {
		//creamos y mostramos array
		int array[] = Utils.creaArrayNumerosAzar(150, 0, 100);
		Utils.mostrarArray(array);
		
		//pedimos número por el que quiere multiplicar al usuario
		int numMultiplicar = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número por el que quiere multiplicar"));
		//introducimos salto de línea
		System.out.println();
		// realizamos bucle for para multiplicar cada número del array
		for (int i = 0; i < array.length; i++) {
			System.out.println("Al multiplicar " + array[i] + " x " + numMultiplicar +
					" el resultado es " + (array[i]*numMultiplicar));
		}

	}

}
