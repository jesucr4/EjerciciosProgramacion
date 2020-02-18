package examen_Jesus_Cano_Ruiz.copy;

import javax.swing.JOptionPane;

public class EjercicioD_desplazar {

	public static void main(String[] args) {
		//creamos array, inicializamos y mostramos en pantalla
		int array[] = Utils.creaArrayNumerosAzar(10, 0, 100);
		Utils.mostrarArray(array);
		System.out.println();
		//creamos variable en la que se guardará la posición del array que quiere eliminar el usuario
		int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduzca de 0 a 10 la posición del "
				+ "del array que desea eliminar"));
		//recorremos array para poner como nula (-1) posición array que nos indique usuario
		// usamos menos uno para eliminar ya que está fuera del rango de los valores pedido para el array
		for (int i = 0; i < array.length; i++) {
			if (array[i]==posicion) {
				array[i] = -1;
			}
		}
		
		// volvemos a recorrer array partiendo de la posición que nos indica
		//el usuario para mover hacia la izquierda los números que se encuentran a la derecha 
		//de la posición indicada
		for (int i = posicion; i < array.length; i++) {
			array[i-1]= array [i];
		}
		//rellenamos hueco libre con número aleatorio mediante un método
		array[9] = Utils.obtenerNumeroAleatorio();
		//mostramos array definitivo en pantalla
		Utils.mostrarArray(array);
	}

}
