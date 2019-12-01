package tema4_OrientaciónaObjetos_Bloque3_Ejercicio03.copy³naObjetos_Bloque3_Ejercicio03;

import javax.swing.JOptionPane;

public class PruebaPersona {

	public static void main(String[] args) {
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("ï¿½Quiere crear nuevo usuario? Pulse: \n -0:Sï¿½ \n -1:No"));
		if (opcion == 0) {
			
			Persona NuevaPersona = new Persona();
			NuevaPersona.Nombre = JOptionPane.showInputDialog("Introduzca nombre persona");
			NuevaPersona.Apellidos = JOptionPane.showInputDialog("Introduzca apellidos persona");
			NuevaPersona.DNI = JOptionPane.showInputDialog("Introduzca DNI persona");
			NuevaPersona.direcciÃ³n = JOptionPane.showInputDialog("Introduzca direcciï¿½n persona");
			NuevaPersona.telÃ©fono = Integer.parseInt(JOptionPane.showInputDialog("Introduzca telï¿½fono persona"));
			
			NuevaPersona.imprimir();
		}else {
			return;
		}
		
		
		}
}


