package examen2018_TIPOA;

import javax.swing.JOptionPane;

public class Ejercicio02_arrays {

	public static void main(String[] args) {
		//pedimos al usuario límite inferior y límite superior del array con el que vamos a trabajar
		int limInf = Integer.parseInt(JOptionPane.showInputDialog("Introduzca límite inferior array"));
		int limSup = Integer.parseInt(JOptionPane.showInputDialog("Introduzca límite superior array"));
		//creamos array y lo inicializamos
		int array[]= new int [10];
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) (Math.round(Math.random()*(limSup-limInf))+limInf);
		}
		//mostramos array en pantalla
		System.out.println("Contenido del array");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		//mostramos en pantalla el array en orden inverso
		System.out.println("Mostramos el array en orden inverso");
		for (int i = array.length-1; i>-1; i--) {
			System.out.print(array[i]+ " ");
		}
			

	}

}
