package tema6_Recursos_Excepciones_EjercicioPar;

import javax.swing.JOptionPane;

public class Main {

	public static int pideNumeroPar () throws NumeroPar {
		
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número par"));
		
		if (num % 2 == 1) {
			throw new NumeroPar("El numero introducido por el usuario es: " + num + " y no es par");
		}else {
			return num;
		}
		
	}
	public static void main(String[] args) {
		try {
			pideNumeroPar();
		}catch (NumeroPar e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
