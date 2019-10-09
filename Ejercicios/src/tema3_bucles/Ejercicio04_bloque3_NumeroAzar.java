package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio04_bloque3_NumeroAzar {

	public static void main(String[] args) {
		int numAzar = obtenerNumeroAzar();
		int num = 0;
		
		for (; num!= numAzar; ) {
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número para ver si coincide con el sacado al azar"));
			if ( num == numAzar) {
				System.out.println("HA ACEPTADO EL NÚMERO!!: el número era" + numAzar);
			}else {
				if ((num > numAzar && numAzar > 90) | (num < numAzar && numAzar > 90))  {
					System.out.println("El número es superior a 90");					
					}
				if ((num > numAzar && numAzar > 80) | (num < numAzar && numAzar > 80)) {
					System.out.println("El número es superior a 80");
				}
				if ((num > numAzar && numAzar > 70) | (num < numAzar && numAzar > 70)) {
					System.out.println("El número es superior a 70");
				}
				if ((num > numAzar && numAzar > 60) | (num < numAzar && numAzar > 60)) {
					System.out.println("El número es superior a 60");
				}
				if ((num > numAzar && numAzar > 50) | (num < numAzar && numAzar > 50)) {
					System.out.println("El número es superior a 50");
				}
				if ((num > numAzar && numAzar > 40) | (num < numAzar && numAzar > 40)) {
					System.out.println("El número es superior a 40");
				}
				if ((num > numAzar && numAzar > 30) | (num < numAzar && numAzar > 30)) {
					System.out.println("El número es superior a 30");
				}
				if ((num > numAzar && numAzar > 20) | (num < numAzar && numAzar > 20)) {
					System.out.println("El número es superior a 20");
				}
				if ((num > numAzar && numAzar > 10) | (num < numAzar && numAzar > 10)) {
					System.out.println("El número es superior a 10");
				}else {
					if (num > numAzar && numAzar < 10)  {
						System.out.println("El número es inferior a 10");
					}
				}
				
				}
				}
				
			}
			
			
		
		
	
	public static int obtenerNumeroAzar () {
		 return (int) Math.round(Math.random() * 100);
	}

}
