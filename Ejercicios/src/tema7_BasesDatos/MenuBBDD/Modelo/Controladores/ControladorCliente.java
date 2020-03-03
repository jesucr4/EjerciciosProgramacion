package tema7_BasesDatos.MenuBBDD.Modelo.Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import tema7_BasesDatos.MenuBBDD.Modelo.Cliente;
import tema7_BasesDatos.MenuBBDD.Modelo.Concesionario;
import tema7_BasesDatos.MenuBBDD.Modelo.Fabricante;



public class ControladorCliente extends ControladorBBDD {

	
	
	public static List<Cliente> getAll () throws ErrorBBDDException, ParseException, ImposibleConectarException {
		List<Cliente> clientes = new ArrayList<Cliente> ();
				
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from cliente");

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setLocalidad(rs.getString("localidad"));
				cliente.setDniNie(rs.getString("dniNie"));
				cliente.setFechaNac(rs.getDate("fechaNac"));
				clientes.add(cliente);
			}
			
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return clientes;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static void almacenar (Cliente cliente) throws ErrorBBDDException, ParseException {
		if (get(cliente.getId()) != null) { // Solo modificar
			almacenarModificado(cliente);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(cliente);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static Cliente get (int id) throws ErrorBBDDException, ParseException {
		Connection conn = null;
		Cliente cli = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from cliente where id = " + id);

			if (rs.next()) {
				cli = new Cliente();
				cli.setId(id);
				cli.setNombre(rs.getString("nombre"));
				cli.setApellidos(rs.getString("apellidos"));
				cli.setLocalidad(rs.getString("localidad"));
				cli.setDniNie(rs.getString("dniNie"));
				cli.setFechaNac(rs.getDate("fechaNac"));
				
			}
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return cli;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Cliente cliente) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"INSERT INTO cliente (id, nombre, apellidos, localidad, dniNie, fechaNac) VALUES  (?, ?, ?, ?, ?, ?)");
			int registrosInsertados;
			
			ps.setInt(1, nextIdEnTabla(conn, "cliente")); 
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getLocalidad());
			ps.setString(5, cliente.getDniNie());
			ps.setString(6, cliente.getFechaNac());

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la inserción del nuevo registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarModificado (Cliente cliente) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"update cliente set nombre = ?, apellidos = ? localidad = ?, dniNie = ?, fechaNac = ? where id = ?");
			int registrosInsertados;
			
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getLocalidad());
			ps.setString(4, cliente.getDniNie());
			ps.setString(5, cliente.getFechaNac());
			ps.setInt(6, cliente.getId()); 
			

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la modificación del registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void eliminar (Cliente cliente) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"delete from cliente where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, cliente.getId()); 

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la eliminación del registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
}
