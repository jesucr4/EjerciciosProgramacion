package tema7_BasesDatos_EjercicioMenuFabricante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import java.sql.Statement;



public class Fabricante {
	private static String tabla = new String("fabricante");
	
	private static Boolean continuarEnMenu = true;
	
	static Scanner sc = new Scanner (System.in);
	
	private static int maxIdEnTabla (Connection conn, String tabla) throws SQLException {
		Statement s = (Statement) conn.createStatement();

		String sql = "select max(id) from tutorialjavacoches." + tabla;
		ResultSet rs = s.executeQuery(sql);
		int max = 1; 
		if (rs.next() ) {
			max = rs.getInt(1);
		}
		rs.close();
		s.close();
		return max;
	}
	private static int nextIdEnTabla (Connection conn, String tabla) throws SQLException {
		return maxIdEnTabla(conn, tabla) + 1;
	}
	
	private static void consultaFabricantes (Connection conn, String tabla) throws SQLException{
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery ( "select * from " + tabla);
		ResultSetMetaData rsmd= rs.getMetaData();			

		

		// Impresión e pantalla de las etiquetas de nombre de las columnas del objeto ResultSet
		System.out.println("\n-------------------------------------------------------------");
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnLabel(i) + "\t");
		} 
		System.out.println("\n-------------------------------------------------------------");
		
		// Recorrido del ResultSet, diferenciando entre los tipos de datos que pueden tener las columnas
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("INT")) {
					System.out.print(rs.getInt(rsmd.getColumnLabel(i)) + "\t");
				}
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("VARCHAR")) {
					System.out.print(rs.getString(rsmd.getColumnLabel(i)) + "\t");
				}
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("DATETIME")) {
					System.out.print(rs.getDate(rsmd.getColumnLabel(i)) + "\t");
				}
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("TINYINT")) {
					System.out.print(rs.getBoolean(rsmd.getColumnLabel(i)) + "\t");
				}
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("FLOAT")) {
					System.out.print(rs.getFloat(rsmd.getColumnLabel(i)) + "\t");
				}
				
			}
			System.out.println("\n");			
		}

		rs.close();
		s.close();
	}
	
	private static void altaNuevoFabricante (Connection conn, String tabla) throws SQLException{
		Statement s = (Statement) conn.createStatement();
		
		int registrosInsertados;
		String sql;
		int contRegistrosInsertados = 0;
		String cif = sc.next();
		String nombreFabricante = sc.next();
		
		sql = "INSERT INTO tutorialjavacoches.fabricante (id, cif, nombre) " +
				"VALUES  (" + nextIdEnTabla(conn, "fabricante") + ", '" + cif + "', '" + nombreFabricante + "')";
		registrosInsertados = s.executeUpdate(sql);
		if (registrosInsertados != 1) {
			throw new SQLException ("No ha sido posible la inserción con la cadena:\n" + sql);
		}
		contRegistrosInsertados++;
		
		System.out.println("Se ha creado nuevo fabricante con CIF: " + cif + " y NOMBRE: " + nombreFabricante );
		
		s.close();
	}
	
	private static void bajaFabricante (Connection conn, String tabla) throws SQLException {
		Statement s = (Statement) conn.createStatement();
		int registrosBorrados;
		String id= sc.next();
		String sql = "delete from tutorialjavacoches.fabricante where fabricante.id="+  id;
		registrosBorrados = s.executeUpdate(sql);
		s.close();
		System.out.println("Fabricante con IDENTIFICADOR:" + id + " ha sido eliminado " );
		
	}
	
	private static void modificarFabricante (Connection conn, String tabla) throws SQLException{
		Statement s = (Statement) conn.createStatement();
		int registrosModificados;
		String id = sc.next();
		String cif = sc.next();
		String nombreFabricante = sc.next();
		
		
		String sql = "UPDATE tutorialjavacoches.fabricante SET fabricante.cif= '"+ cif +"', fabricante.nombre= '"+ nombreFabricante + "' where fabricante.id="+id;
		registrosModificados = s.executeUpdate(sql);
		s.close();
	}
	
	public static Boolean getContinuarEnMenu() {
		return continuarEnMenu;
	}
	public static void setContinuarEnMenu(Boolean continuarEnMenu) {
		Fabricante.continuarEnMenu = continuarEnMenu;
	}

	public static void main(String[] args) {
		
		try {
			long startTime = new Date().getTime();
			
			Connection conn;
			conn = ConnectionManagerV2.getConexion();
			
			do {
			System.out.println("\n\n\tOpciones fabricante" + "\n\n\t1. Listado de fabricantes" + 
					"\n\n \t2. Alta de fabricante " + 
					"\n\n \t3. Modificar fabricante " + 
					"\n\n \t4. Baja de fabricante " + 
					"\n\n \t0. Salir ");
					
					String opcion = sc.next();
					
					switch (opcion) {
					case "1":
						consultaFabricantes(conn, tabla);
						break;
					case "2":
						System.out.println("Alta fabricantes");
						System.out.println("Introduzca CIF y nombre fabricante");
						altaNuevoFabricante(conn, tabla);
						break;
					case "3":
						System.out.println("Modificar fabricantes");
						System.out.println("Introduzca ID del Fabricante que desea modificar");
						System.out.println("Introduzca nuevo CIF y nombre del fabricante");
						modificarFabricante(conn, tabla);
						/*System.out.println();
						System.out.println("Introduzca ID del que desea modificar sus datos");
						System.out.println();
						System.out.println("Introduzca nuevo CIF o pulse INTRO para modificar nombre");
						System.out.println();
						System.out.println("Introduzca modificación de NOMBRE o pulse intro para continuar");
						System.out.println();*/
						
						break;
					case "4":
						System.out.println("Baja fabricantes");
						System.out.println("Introduzca ID del fabricante que desea eliminar");
						bajaFabricante(conn, tabla);
						break;
					case "0":
						setContinuarEnMenu(false);
						System.out.println("HA FINALIZADO LA GESTIÓN DE SU LISTA DE FABRICANTES");
						System.exit(0);
						
					default:
						System.out.println("Debe introducir un número entre 0 y 4");
					}
			}while(continuarEnMenu);	
			
			long usedMillis = new Date().getTime() - startTime;
			int secs = (int) (usedMillis/1000);
			System.out.println("\nProceso terminado en " + secs + " segundos y " + (usedMillis - secs * 1000) + " milisegundos");
			
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
