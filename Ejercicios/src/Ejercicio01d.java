import javax.swing.JOptionPane;

public class Ejercicio01d {

	public static void main(String[] args) {
		mediaNúmeros();

	}
	public static void mediaNúmeros() {
		String str = JOptionPane.showInputDialog("Introduzca número entero");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca número flotante");
		Float num2 = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca número double");
		Double num3 = Double.parseDouble(str);
		
		System.out.println("La meida de los tres número es " + (num1 + num2 + num3)/3);
	}

}
