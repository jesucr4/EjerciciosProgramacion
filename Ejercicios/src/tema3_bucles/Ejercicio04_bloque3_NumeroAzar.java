package tema3_bucles;

import javax.swing.JOptionPane;

public class Ejercicio04_bloque3_NumeroAzar {

	public static void main(String[] args) {
		int numAzar = obtenerNumeroAzar();
		int num = 0;
		
		for (; num!= numAzar; ) {
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número para ver si coincide con el sacado al azar"));
			if ( num == numAzar) {
				System.out.println("HA ACERTADO EL NÚMERO!!: el número era" + numAzar);
			}else {
				if ((num > numAzar && numAzar >= 90) | (num < numAzar && numAzar >= 90))  {
					System.out.println("El n�mero al azar es mayor o igual de 90");					
					}else {
					if ((num > numAzar && numAzar >= 80) | (num < numAzar && numAzar >= 80))  {
						System.out.println("El n�mero al azar est� entre 80 y 90");					
						}else {
							if ((num > numAzar && numAzar >= 70) | (num < numAzar && numAzar >= 70))  {
								System.out.println("El n�mero al azar est� entre 70 y 80");					
								}else {
									if ((num > numAzar && numAzar >= 60) | (num < numAzar && numAzar >= 60))  {
										System.out.println("El n�mero al azar est� entre 60 y 70");					
										}else {
											if ((num > numAzar && numAzar >= 50) | (num < numAzar && numAzar >= 50))  {
												System.out.println("El n�mero al azar est� entre 50 y 60");					
												}else {
													if ((num > numAzar && numAzar >= 40) | (num < numAzar && numAzar >= 40))  {
														System.out.println("El n�mero al azar est� entre 40 y 50");					
														}else {
															if ((num > numAzar && numAzar >= 30) | (num < numAzar && numAzar >= 30))  {
																System.out.println("El n�mero al azar est� entre 30 y 40");					
																}else {
																	if ((num > numAzar && numAzar >= 20) | (num < numAzar && numAzar >= 20))  {
																		System.out.println("El n�mero al azar est� entre 20 y 30");					
																		}else {
																			if ((num > numAzar && numAzar >= 10) | (num < numAzar && numAzar >= 10))  {
																				System.out.println("El n�mero al azar est� entre 10 y 20");					
																				}else {
																					System.out.println("El n�mero al azar es menor de diez 10");
																				}
																		}
				
																}
														}
												}
										}
								}
						}
					}
			}
		}
	}
			
		
		
	
	public static int obtenerNumeroAzar () {
		 return (int) Math.round(Math.random() * 100);
	}

}
