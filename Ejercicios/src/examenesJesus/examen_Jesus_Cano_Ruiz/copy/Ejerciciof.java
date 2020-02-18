package examen_Jesus_Cano_Ruiz.copy;

public class Ejerciciof {

	public static void main(String[] args) {
		//creamos array y lo mostramos en pantalla
		int array[] = Utils.creaArrayNumerosAzar(100, -100, 100);
		Utils.mostrarArray(array);
		System.out.println();
		//creamos un contador para ver cuantos números hay entre los pedidos
		float contNum= 0;
		//realizamos bucle for para recorrer array y ver que números se 
		//encuentran entre los pedidos
		for (int i = 0; i < array.length; i++) {
			if(array[i] >=50 && array[i]<=90) {
				contNum++;
			}
		}
		// realizamos operación para obtener porcentaje y mostramos en pantalla
		float porcentaje = contNum/100;
		System.out.println("El porcentaje de números entre 50 y 90 es " + 
		porcentaje + "%");
	}

}
