package tema2;

public class Ejercicio04_bloque3_cambioMoneda {

	public static void main(String[] args) {
		int precio = 6742; // 67,42 €
		int pago = 10000; // 100,00 €
		
		int cambioADevolver = pago - precio;
		
		// Calculo la cantidad de billetes de 100,00 €
		System.out.println("Devuelvo " + (cambioADevolver / 10000)  + " billetes de 100.00 €");
		cambioADevolver %= 10000;

		// Calculo la cantidad de billetes de 50,00 €
		System.out.println("Devuelvo " + (cambioADevolver / 5000)  + " billetes de 50.00 €");
		cambioADevolver %= 5000;

		// Calculo la cantidad de billetes de 20,00 €
		System.out.println("Devuelvo " + (cambioADevolver / 2000)  + " billetes de 20.00 €");
		cambioADevolver %= 2000;

		// Calculo la cantidad de billetes de 10,00 €
		System.out.println("Devuelvo " + (cambioADevolver / 1000)  + " billetes de 10.00 €");
		cambioADevolver = cambioADevolver % 1000;

		// Calculo la cantidad de billetes de 5,00 €
		System.out.println("Devuelvo " + (cambioADevolver / 500)  + " billetes de 5.00 €");
		cambioADevolver = cambioADevolver % 500;

		// Calculo la cantidad de monedas de 2,00 €
		System.out.println("Devuelvo " + (cambioADevolver / 200)  + " monedas de 2.00 €");
		cambioADevolver = cambioADevolver % 200;

		// Calculo la cantidad de monedas de 1,00 €
		System.out.println("Devuelvo " + (cambioADevolver / 100)  + " monedas de 1.00 €");
		cambioADevolver = cambioADevolver % 100;

		// Calculo la cantidad de monedas de 0,50 €
		System.out.println("Devuelvo " + (cambioADevolver / 50)  + " monedas de 0.50 €");
		cambioADevolver = cambioADevolver % 50;

		// Calculo la cantidad de monedas de 0,20 €
		System.out.println("Devuelvo " + (cambioADevolver / 20)  + " monedas de 0.20 €");
		cambioADevolver = cambioADevolver % 20;

		// Calculo la cantidad de monedas de 0,10 €
		System.out.println("Devuelvo " + (cambioADevolver / 10)  + " monedas de 0.10 €");
		cambioADevolver = cambioADevolver % 10;

		// Calculo la cantidad de monedas de 0,05 €
		System.out.println("Devuelvo " + (cambioADevolver / 5)  + " monedas de 0.05 €");
		cambioADevolver = cambioADevolver % 5;

		// Calculo la cantidad de monedas de 0,02 €
		System.out.println("Devuelvo " + (cambioADevolver / 2)  + " monedas de 0.02 €");
		cambioADevolver = cambioADevolver % 2;

		// Calculo la cantidad de monedas de 0,01 €
		System.out.println("Devuelvo " + (cambioADevolver / 1)  + " monedas de 0.01 €");
		cambioADevolver = cambioADevolver % 1;
	}
		

	}


