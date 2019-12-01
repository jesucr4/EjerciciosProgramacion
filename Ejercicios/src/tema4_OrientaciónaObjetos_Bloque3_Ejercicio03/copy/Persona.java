package tema4_Orientaci�naObjetos_Bloque3_Ejercicio03.copy�naObjetos_Bloque3_Ejercicio03;

//import javax.swing.JOptionPane;

public class Persona {
	String Nombre;
	String Apellidos;
	String DNI;
	String dirección;
	int teléfono;


	//public Persona (String NuevoNombre, String NuevoApellido, String NuevoDNI, String NuevaDirecci�n, int NuevoTlfn) {
		
		//Nombre = JOptionPane.showInputDialog("Introduzca nuevo nombre" + NuevoNombre);
		//Apellidos =  JOptionPane.showInputDialog("Introduzca apellidos" + NuevoApellido);
		//DNI = JOptionPane.showInputDialog("Introduzca DNI" + NuevoDNI);
		//direcci�n = JOptionPane.showInputDialog("Introduzca direcci�n" + NuevaDirecci�n);
		//tel�fono = Integer.parseInt(JOptionPane.showInputDialog("Introduzca tel�fono" + NuevoTlfn));
	//}
	
	public void imprimir() {
		System.out.println("Nombre " + Nombre + " - apellidos: " +
				Apellidos + " - DNI: " + DNI + " -direcci�n: " + dirección + " -tel�fono " + teléfono);
	}

}



