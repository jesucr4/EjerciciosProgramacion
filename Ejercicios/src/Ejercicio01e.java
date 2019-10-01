import javax.swing.JOptionPane;

public class Ejercicio01e {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ejercicio();

		}
		
		public static void ejercicio() {
			String str = JOptionPane.showInputDialog("Introduzca número entero ");
			int numA = Integer.parseInt(str);
			
			str = JOptionPane.showInputDialog("Introduzca número entero ");
			int numB = Integer.parseInt(str);
			
			
			System.out.println("Un número entero A es " +  numA + " el otro número B entero es " + numB);
			
			 int aux = numA;
			 numA = numB;
			 numB = aux;
			 
			 System.out.println(" Las variables son " + numA + " y " + numB);
	}

}
