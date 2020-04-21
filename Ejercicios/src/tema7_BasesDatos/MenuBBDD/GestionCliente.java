package tema7_BasesDatos.MenuBBDD;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import tema7_BasesDatos.MenuBBDD.Modelo.Cliente;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ControladorCliente;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ErrorBBDDException;
import tema7_BasesDatos.MenuBBDD.Modelo.Controladores.ImposibleConectarException;




public class GestionCliente {

	
	/**
	 * @throws ParseException 
	 * @throws ImposibleConectarException 
	 * 
	 */
	public static void menuGestion() throws ParseException, ImposibleConectarException {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE CLIENTES");
				
				System.out.println("\n\t1.- Listado de CLIENTES.");
				System.out.println("\t2.- Alta de CLIENTES.");
				System.out.println("\t3.- Modificación de CLIENTES.");
				System.out.println("\t4.- Baja de CLIENTES.");
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
			} catch (ErrorBBDDException e) {
				System.out.println("\n\t\t\tError de acceso a datos: " + e.getMessage() + "\n");
				e.printStackTrace();
			}
		} while (opcionElegida != 0);
	}

	
	/**
	 * 
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 * @throws ImposibleConectarException 
	 */
	private static void listado(boolean pausafinal) throws ErrorBBDDException, ParseException, ImposibleConectarException {
		List<Cliente> clientes = ControladorCliente.getAll();
		System.out.println("\n\tListado de clientes: \n");
		for (Cliente cli : clientes) {
			System.out.println("\t" + cli.toString());
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
	private static void alta () throws ErrorBBDDException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("\n\tAlta de cliente\n");
		
		Cliente cli = new Cliente();
		System.out.print("\nIntroduzca 'Nombre' del cliente: ");
		cli.setNombre(Utils.getStringConsola());
		System.out.print("\nIntroduzca 'Apellidos ' del cliente: ");
		cli.setApellidos(Utils.getStringConsola());
		System.out.print("\nIntroduzca 'Localidad' del cliente: ");
		cli.setLocalidad(Utils.getStringConsola());
		System.out.print("\nIntroduzca 'Dni' del cliente: ");
		cli.setDniNie(Utils.getStringConsola());
		System.out.print("\nIntroduzca 'Fecha Nacimiento' del cliente: ");
		try {
			cli.setFechaNac( sdf.parse(Utils.getStringConsola()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControladorCliente.almacenar(cli);  

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}



	/**
	 * 
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 * @throws ImposibleConectarException 
	 */
	private static void modificacion () throws ErrorBBDDException, ParseException, ImposibleConectarException {
		System.out.println("\n\tModificación de clientes\n");
		
		
		
		Cliente cli = seleccionPorUsuario();
		
		if (cli != null) {		
			String str = Utils.getStringConsola();
			System.out.print("\nIntroduzca 'Nombre' del cliente  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				cli.setNombre(str);
			System.out.print("\nIntroduzca 'Apellidos' del cliente  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				cli.setApellidos(str);
			System.out.print("\nIntroduzca 'Localidad' del cliente  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				cli.setLocalidad(str);
			System.out.print("\nIntroduzca 'DNI' del cliente  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				cli.setDniNie(str);
			System.out.print("\nIntroduzca 'Fecha de nacimiento' del cliente  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				
			ControladorCliente.almacenar(cli);  

			System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
			Utils.pausa();
		}
	}

	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 * @throws ImposibleConectarException 
	 */
	private static void baja () throws ErrorBBDDException, ParseException, ImposibleConectarException {
		System.out.println("\n\tBaja de cliente\n");
		
		Cliente cli = seleccionPorUsuario();
		
		if (cli != null) {		
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) { 		 
				ControladorCliente.eliminar(cli);  
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
	 * @throws ImposibleConectarException 
	 */
	private static Cliente seleccionPorUsuario () throws ErrorBBDDException, ParseException, ImposibleConectarException {
		Cliente cli = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del fabricante ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			}
			else {
				if (id != 0) {
					cli = ControladorCliente.get(id);
					if (cli == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (cli == null && id != 0);
		return cli;
	}
}
