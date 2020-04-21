import java.text.ParseException;

import model.Controladores.ImposibleConectarException;



public class Main {

	public static void main(String[] args) throws ParseException, ImposibleConectarException {
		menuPrincipal();

	}
	private static void menuPrincipal() throws ParseException, ImposibleConectarException{
	int opcionElegida;
	do {
		System.out.println("\n\t\t\tGESTIÓN DE VENTAS DE COCHES");
		
		System.out.println("\n\t1.- Gestión de fabricantes.");
		System.out.println("\t2.- Gestión de concesionario.");
		System.out.println("\t3.- Gestión de clientes.");
		System.out.println("\t4.- Gestión de coche.");
		System.out.println("\t5.- Gestión de ventas.");
		System.out.println("\t0.- Salir");
		System.out.println("\n\tElija una opción: ");
		
		opcionElegida = Utils.getIntConsola(0, 5);
		
		switch (opcionElegida) {
		case 0:
			System.out.println("\n!Qué tenga un feliz día!");
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
