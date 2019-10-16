package tema5_arrays_bloque01;

import javax.swing.JOptionPane;

public class Ejercicio03_array_BúsquedaValor {

	public static void main(String[] args) {
		//creamos array de 150 números
		int numero[] = new int [150];
		
		//inicializamos array
		for (int i= 0; i< numero.length; i++) {
			numero[i]= numeroAleatorio();
		}
		
		
		//imprimimos array
		for (int i = 0; i < numero.length; i++) {
			System.out.print(numero[i]);
		}
		// pedimos al usuario que nos indique un número
		int numUsuario = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número a buscar"));
		
		//incluimos salto de línea
		System.out.println();
		
		//creamos contador apariciones 
		int contApariciones = 0;
		for (int i = 0; i < numero.length; i++) {
			if (numUsuario == numero[i]) {
				System.out.println("El numero buscado " + numUsuario + " se encuentra en la posición " + i);
				contApariciones++;
			}
		}
		
		if (contApariciones == 0) {
			System.out.println("El número " + numUsuario + " no se encuentra en el array");
		}
		
		
		
		
	}
	
	/**
	 * 
	 * @return
	 */
	//ponemos el método en private porque se encuentra en el mismo archivo que donde lo vamos a usar
	private static int numeroAleatorio () {
		 return (int) Math.round(Math.random() * 100);
	}
	
	
}
