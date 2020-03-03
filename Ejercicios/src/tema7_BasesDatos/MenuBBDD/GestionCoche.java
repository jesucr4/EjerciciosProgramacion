package tema7_BasesDatos.MenuBBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import tema7_BasesDatos.MenuBBDD.Modelo.Coche;
import tema7_BasesDatos.MenuBBDD.Modelo.Venta;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ConnectionManagerV2;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ControladorCoche;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ControladorVenta;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ErrorBBDDException;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ImposibleConectarException;


public class GestionCoche {

	/**
	 * @throws ParseException
	 * 
	 */
	public static void menuGestion() throws ParseException {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE COCHE");

				System.out.println("\n\t1.- Listado de coches.");
				System.out.println("\t2.- Alta de un coche.");
				System.out.println("\t3.- Modificación de un coche.");
				System.out.println("\t4.- Baja de un coche.");
				System.out.println("\t0.- Salir");
				System.out.println("\n\tElija una opción: ");

				opcionElegida = Utils.getIntConsola(0, 4);

				switch (opcionElegida) {
				case 0:
					break;
				case 1:
					listado(true);
					break;
				case 2:
					alta();
					break;
				case 3:
					modificacion();
					break;
				case 4:
					baja();
					break;
				}
			} catch (ErrorBBDDException | ImposibleConectarException e) {
				System.out.println("\n\t\t\tError de acceso a datos: " + e.getMessage() + "\n");
				e.printStackTrace();
			}
		} while (opcionElegida != 0);
	}

	/**
	 * 
	 * @throws ErrorBBDDException
	 * @throws ParseException
	 */
	private static void listado(boolean pausafinal)
			throws ErrorBBDDException, ImposibleConectarException, ParseException {
		List<Coche> coches = ControladorCoche.getAll();
		System.out.println("\n\tListado de coches: \n");
		for (Coche coche : coches) {
			System.out.println("\t" + coche.toString());
		}
		if (pausafinal) {
			System.out.println("\n\tPulse 'Intro' tecla para continuar");
			Utils.pausa();
		}
	}

	/**
	 * 
	 * @throws ErrorBBDDException
	 * @throws ParseException
	 */
	private static void alta() throws ErrorBBDDException, ParseException {
		System.out.println("\n\tAlta de coche\n");
		Coche car = new Coche();
		int idFabr = -1;
		while (idFabr < 0) {
			System.out.print("\nIntroduzca 'ID fabricante' de coche ");
			idFabr = buscarIdFabricante(Utils.getStringConsola());
		}
		car.setIdFabricante(idFabr);
		System.out.println("\n Introduzca bastidor del coche");
		car.setBastidor(Utils.getStringConsola());
		System.out.println("\n Introduzca modelo del coche");
		car.setModelo(Utils.getStringConsola());
		System.out.println("\n Introduzca color del coche");
		car.setColor(Utils.getStringConsola());
		
		car.setIdFabricante(idFabr);
		

		

		ControladorCoche.almacenar(car);

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}

	private static int buscarIdFabricante(String idFabricante) throws ErrorBBDDException {
		Connection conn = null;
		int id = -1;

		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select id from fabricante where id = " + idFabricante);

			if (rs.next()) {
				id = rs.getInt("id");
			}
			s.close();

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}
		return id;
	}


	/**
	 * 
	 * @throws ErrorBBDDException
	 * @throws ParseException
	 */
	private static void modificacion() throws ErrorBBDDException, ImposibleConectarException, ParseException {
		System.out.println("\n\tModificación de coche\n");

		Coche car = seleccionPorUsuario();

		if (car != null) {
			System.out.print("\nIntroduzca 'ID' del fabricante a modificar ('Intro' para no modificar): ");
			String str = Utils.getStringConsola();
			if (!str.equals("")) {
				int idFab = -1;
				idFab = buscarIdFabricante(str);
				while (idFab < 0) {
					System.out.print("\nIntroduzca 'ID' del fabricante del coche: ");
					idFab = buscarIdFabricante(Utils.getStringConsola());
				}
				car.setIdFabricante(idFab);
				
			}
			
			System.out.print("\nIntroduzca bastidor del coche ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				car.setBastidor(str);
			System.out.print("\nIntroduzca modelo del coche ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				car.setModelo(str);
			System.out.print("\nIntroduzca color del coche ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				car.setColor(str);
			ControladorCoche.almacenar(car);

			System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
			Utils.pausa();
		}
	}

	/**
	 * 
	 * @throws ErrorBBDDException
	 * @throws ParseException
	 */
	private static void baja() throws ErrorBBDDException, ImposibleConectarException, ParseException {
		System.out.println("\n\tBaja de coche\n");

		Coche car = seleccionPorUsuario();

		if (car != null) {
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) {
				ControladorCoche.eliminar(car);
				System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
				Utils.pausa();
			}
		}
	}

	/**
	 * 
	 * @return
	 * @throws ErrorBBDDException
	 * @throws ParseException
	 */
	private static Coche seleccionPorUsuario() throws ErrorBBDDException, ImposibleConectarException, ParseException {
		Coche car = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del coche ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			} else {
				if (id != 0) {
					car = ControladorCoche.get(id);
					if (car == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (car == null && id != 0);
		return car;
	}
}
