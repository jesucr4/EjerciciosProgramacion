package tema4_OrientaciónaObjetos_Bloque3_Ejercicio03;

import javax.swing.JOptionPane;

public class PruebaPersona {

	public static void main(String[] args) {
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("�Quiere crear nuevo usuario? Pulse: \n -0:S� \n -1:No"));
		if (opcion == 0) {
			
			Persona NuevaPersona = new Persona();
			NuevaPersona.Nombre = JOptionPane.showInputDialog("Introduzca nombre persona");
			NuevaPersona.Apellidos = JOptionPane.showInputDialog("Introduzca apellidos persona");
			NuevaPersona.DNI = JOptionPane.showInputDialog("Introduzca DNI persona");
			NuevaPersona.dirección = JOptionPane.showInputDialog("Introduzca direcci�n persona");
			NuevaPersona.teléfono = Integer.parseInt(JOptionPane.showInputDialog("Introduzca tel�fono persona"));
			
			NuevaPersona.imprimir();
		}else {
			return;
		}
		
		
		}
}


