package tema1;
import javax.swing.JOptionPane;

public class Ejercicio01d {

	public static void main(String[] args) {
		mediaNúmeros();

	}
	public static void mediaNúmeros() {
		String str = JOptionPane.showInputDialog("Introduzca n�mero entero");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca n�mero flotante");
		Float num2 = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca n�mero double");
		Double num3 = Double.parseDouble(str);
		
		System.out.println("La meida de los tres n�mero es " + (num1 + num2 + num3)/3);
	}

}
