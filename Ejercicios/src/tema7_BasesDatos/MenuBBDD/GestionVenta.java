package tema7_BasesDatos.MenuBBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import tema7_BasesDatos.MenuBBDD.Modelo.Venta;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ConnectionManagerV2;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ControladorVenta;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ErrorBBDDException;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ImposibleConectarException;


public class GestionVenta {

	/**
	 * @throws ParseException
	 * 
	 */
	public static void menuGestion() throws ParseException {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE VENTAS");

				System.out.println("\n\t1.- Listado de ventas.");
				System.out.println("\t2.- Alta de una venta.");
				System.out.println("\t3.- Modificación de venta.");
				System.out.println("\t4.- Baja de venta.");
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
		List<Venta> ventas = ControladorVenta.getAll();
		System.out.println("\n\tListado de ventas: \n");
		for (Venta venta : ventas) {
			System.out.println("\t" + venta.toString());
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
		System.out.println("\n\tAlta de venta\n");
		Venta venta = new Venta();
		int idClie = -1;
		while (idClie < 0) {
			System.out.print("\nIntroduzca 'DNI' del cliente en la venta ");
			idClie = buscarIdCliente(Utils.getStringConsola());
		}
		int idCon = -1;
		while (idCon < 0) {
			System.out.print("\nIntroduzca 'cif' del concesionario en la venta ");
			idCon = buscarIdConcesionario(Utils.getStringConsola());
		}
		int idCoche = -1;
		while (idCoche < 0) {
			System.out.print("\nIntroduzca 'bastidor' del coche en la venta ");
			idCoche = buscarIdCoche(Utils.getStringConsola());
		}
		venta.setIdCliente(idClie);
		venta.setIdConcesionario(idCon);
		venta.setIdCoche(idCoche);

		System.out.print("\nIntroduzca 'Fecha' de la venta: ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		venta.setFecha(sdf.parse(Utils.getStringConsola()));
		System.out.print("\nIntroduzca 'precioVenta' de la venta: ");
		venta.setPrecioVenta((Utils.getStringConsola()));

		ControladorVenta.almacenar(venta);

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}

	private static int buscarIdCliente(String dniNie) throws ErrorBBDDException {
		Connection conn = null;
		int id = -1;

		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select id from cliente where dniNie = " + dniNie);

			if (rs.next()) {
				id = rs.getInt("id");
			}
			s.close();

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}
		return id;
	}

	private static int buscarIdConcesionario(String cif) throws ErrorBBDDException {
		Connection conn = null;
		int id = -1;

		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select id from concesionario where cif = " + cif);

			if (rs.next()) {
				id = rs.getInt("id");
			}
			s.close();

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}
		return id;
	}

	private static int buscarIdCoche(String bastidor) throws ErrorBBDDException {
		Connection conn = null;
		int id = -1;

		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select id from coche where bastidor = " + bastidor);

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
		System.out.println("\n\tModificación de venta\n");

		Venta venta = seleccionPorUsuario();

		if (venta != null) {
			System.out.print("\nIntroduzca 'dniNie' del fabricante a modificar ('Intro' para no modificar): ");
			String str = Utils.getStringConsola();
			if (!str.equals("")) {
				int idClie = -1;
				idClie = buscarIdCliente(str);
				while (idClie < 0) {
					System.out.print("\nIntroduzca 'dniNie' del fabricante del coche: ");
					idClie = buscarIdCliente(Utils.getStringConsola());
				}
				venta.setIdCliente(idClie);
			}
			System.out.print("\nIntroduzca 'CIF' del concesionario a modificar ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) {
				int idCon = -1;
				idCon = buscarIdConcesionario(str);
				while (idCon < 0) {
					System.out.print("\nIntroduzca 'CIF' del concesionario del coche: ");
					idCon = buscarIdConcesionario(Utils.getStringConsola());
				}
				venta.setIdConcesionario(idCon);
			}
			System.out.print("\nIntroduzca 'bastidor' del coche a modificar ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) {
				int idCoche = -1;
				idCoche = buscarIdCoche(str);
				while (idCoche < 0) {
					System.out.print("\nIntroduzca 'CIF' del fabricante del coche: ");
					idCoche = buscarIdCoche(Utils.getStringConsola());
				}
				venta.setIdCoche(idCoche);
			}
			System.out.print("\nIntroduzca 'fecha' de la venta  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if (!str.equals(""))
				venta.setFecha(sdf.parse(str));
			System.out.print("\nIntroduzca 'precioVenta' de la venta  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals(""))
				venta.setPrecioVenta(str);

			ControladorVenta.almacenar(venta);

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
		System.out.println("\n\tModificación de venta\n");

		Venta venta = seleccionPorUsuario();

		if (venta != null) {
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) {
				ControladorVenta.eliminar(venta);
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
	private static Venta seleccionPorUsuario() throws ErrorBBDDException, ImposibleConectarException, ParseException {
		Venta cliente = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID de la venta ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			} else {
				if (id != 0) {
					cliente = ControladorVenta.get(id);
					if (cliente == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (cliente == null && id != 0);
		return cliente;
	}
}
