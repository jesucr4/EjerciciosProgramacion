package tema4_OrientaciónaObjetos_Bloque3_Ejercicio03;

import javax.swing.JOptionPane;

public class Persona {
	String Nombre;
	String Apellidos;
	String DNI;
	String dirección;
	int teléfono;


	//public Persona (String NuevoNombre, String NuevoApellido, String NuevoDNI, String NuevaDirección, int NuevoTlfn) {
		
		//Nombre = JOptionPane.showInputDialog("Introduzca nuevo nombre" + NuevoNombre);
		//Apellidos =  JOptionPane.showInputDialog("Introduzca apellidos" + NuevoApellido);
		//DNI = JOptionPane.showInputDialog("Introduzca DNI" + NuevoDNI);
		//dirección = JOptionPane.showInputDialog("Introduzca dirección" + NuevaDirección);
		//teléfono = Integer.parseInt(JOptionPane.showInputDialog("Introduzca teléfono" + NuevoTlfn));
	//}
	
	public void imprimir() {
		System.out.println("Nombre " + Nombre + " - apellidos: " +
				Apellidos + " - DNI: " + DNI + " -dirección: " + dirección + " -teléfono " + teléfono);
	}

}



