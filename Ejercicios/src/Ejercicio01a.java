import javax.swing.JOptionPane;

public class Ejercicio01a {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca número entero");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca número flotante");
		Float num2 = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca número double");
		Double num3 = Double.parseDouble(str);
		
		System.out.println("El número entero es " + num1 + ", el número flotante es " + num2 +
				" y el número double es " + num3);
		
	}

}
