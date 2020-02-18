package examen_Jesus_Cano_Ruiz.copy;

import javax.swing.JOptionPane;

public class Ejercicio03_3arraysCopia {

	public static void main(String[] args) {
		//creamos tres arrays, el array de 10 posiciones que se rellenará con 
		//los dos arrays anteriores y los dos arrays que nos servirán para 
		//rellenar este array
		int arrayConjunto[]=new int[4];
		int primerArray[] = new int [2];
		int segundoArray[] = new int [2];
		//creamos contador posiciones que se han ocupado para seguir rellenando
		//9int contPos = 0;
		//realizamos bucle for para pedir que usuario introduzca números a cada array
		for (int i = 0; i < arrayConjunto.length; i++) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número para rellenar array"));
			if(i%2==0) {
				primerArray[i]=num;
			}else {
				segundoArray[i]=num;
			}
		}
		//mostramos en pantalla primer array
		for (int i = 0; i < primerArray.length; i++) {
			System.out.print(primerArray[i]+ " ");
		}
	
		//mostramos en pantalla segundo array
		System.out.println();
		for (int i = 0; i < segundoArray.length; i++) {
			System.out.print(segundoArray[i]+ " ");
		}
		//mediante bucle for rellenamos el tercer array con los valores del primero hasta la cantidad de posiciones que tiene hemos contado con el contador
		for (int i = 0; i < arrayConjunto.length; i++) {
			if (i % 2 == 0) {
				arrayConjunto[i] = primerArray[i];
				Utils.mostrarArray(arrayConjunto);
			}
			else {
				arrayConjunto[i] = segundoArray[i];
				Utils.mostrarArray(arrayConjunto);
			}
		}
		Utils.mostrarArray(arrayConjunto);
	}
}


