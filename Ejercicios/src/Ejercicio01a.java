import javax.swing.JOptionPane;

public class Ejercicio01a {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca n�mero entero");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca n�mero flotante");
		Float num2 = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca n�mero double");
		Double num3 = Double.parseDouble(str);
		
		System.out.println("El n�mero entero es " + num1 + ", el n�mero flotante es " + num2 +
				" y el n�mero double es " + num3);
		
	}

}
