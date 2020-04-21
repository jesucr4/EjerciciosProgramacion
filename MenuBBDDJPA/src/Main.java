import java.text.ParseException;

import model.Controladores.ImposibleConectarException;



public class Main {

	public static void main(String[] args) throws ParseException, ImposibleConectarException {
		menuPrincipal();

	}
	private static void menuPrincipal() throws ParseException, ImposibleConectarException{
	int opcionElegida;
	do {
		System.out.println("\n\t\t\tGESTI�N DE VENTAS DE COCHES");
		
		System.out.println("\n\t1.- Gesti�n de fabricantes.");
		System.out.println("\t2.- Gesti�n de concesionario.");
		System.out.println("\t3.- Gesti�n de clientes.");
		System.out.println("\t4.- Gesti�n de coche.");
		System.out.println("\t5.- Gesti�n de ventas.");
		System.out.println("\t0.- Salir");
		System.out.println("\n\tElija una opci�n: ");
		
		opcionElegida = Utils.getIntConsola(0, 5);
		
		switch (opcionElegida) {
		case 0:
			System.out.println("\n!Qu� tenga un feliz d�a!");
			break;
		case 1:
			GestionFabricante.menuGestion();
			break;
		case 2:
			GestionConcesionario.menuGestion();
		
			break;
		case 3:
			GestionCliente.menuGestion();
			break;
		case 4:
			GestionCoche.menuGestion();
			break;
		case 5:
			//GestionVenta.menuGestion();
			break;
		}
	} while (opcionElegida != 0);
}

}
