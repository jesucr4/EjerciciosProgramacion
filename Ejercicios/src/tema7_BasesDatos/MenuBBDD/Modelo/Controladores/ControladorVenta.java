package tema7_BasesDatos.MenuBBDD.Modelo.Controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import tema7_BasesDatos.MenuBBDD.Modelo.Venta;



public class ControladorVenta extends ControladorBBDD {

	public static List<Venta> getAll() throws ErrorBBDDException, ImposibleConectarException, ParseException {
		List<Venta> venta = new ArrayList<Venta>();

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from venta");

			while (rs.next()) {
				Venta ven = new Venta();
				ven.setId(rs.getInt("id"));
				ven.setIdCliente(rs.getInt("idCliente"));
				ven.setIdConcesionario(rs.getInt("idConcesionario"));
				ven.setIdCoche(rs.getInt("idCoche"));
				ven.setFecha(rs.getDate("fecha"));
				ven.setPrecioVenta(rs.getString("precioVenta"));
				venta.add(ven);
			}

			s.close();

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}
		return venta;
	}

	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static void almacenar(Venta cliente) throws ErrorBBDDException, ParseException {
		if (get(cliente.getId()) != null) { // Solo modificar
			almacenarModificado(cliente);
		} else { // Crear nuevo objeto en la BBDD
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
	public static Venta get(int id) throws ErrorBBDDException, ParseException {
		Connection conn = null;
		Venta vent = null;
		System.out.println(id);
		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from venta where id = " + id);

			if (rs.next()) {
				vent = new Venta();
				vent.setId(rs.getInt("id"));
				vent.setIdCliente(rs.getInt("idCliente"));
				vent.setIdConcesionario(rs.getInt("idConcesionario"));
				vent.setIdCoche(rs.getInt("idCoche"));
				vent.setFecha(rs.getDate("fecha"));
				vent.setPrecioVenta(rs.getString("precioVenta"));
			}
			s.close();

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}
		return vent;
	}

	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo(Venta cliente) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("INSERT INTO venta (id, idCliente, idConcesionario, idCoche, fecha, precioVenta) VALUES  (?, ?, ?, ?, ?, ?)");
			int registrosInsertados;

			ps.setInt(1, nextIdEnTabla(conn, "venta"));
			ps.setInt(2, cliente.getIdCliente());
			ps.setInt(3, cliente.getIdConcesionario());
			ps.setInt(4, cliente.getIdCoche());
			ps.setString(5,  cliente.getFecha());
			ps.setString(6, cliente.getPrecioVenta());
			

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException("No ha sido posible la inserción del nuevo registro");
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
	private static void almacenarModificado(Venta cliente) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("update venta set id = ?, idCliente = ?, idConcesionario = ?, idCoche, fecha = ?, precioVenta = ? where id = ?");
			int registrosInsertados;

			ps.setInt(1, cliente.getIdCliente());
			ps.setInt(2, cliente.getIdConcesionario());
			ps.setInt(3, cliente.getIdCoche());
			ps.setString(4,  cliente.getFecha());
			ps.setString(5, cliente.getPrecioVenta());
			ps.setInt(6, cliente.getId());

			
			
			registrosInsertados = ps.executeUpdate();
			
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException("No ha sido posible la modificación del registro");
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
	public static void eliminar(Venta cliente) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("delete from venta where id = ?");
			int registrosInsertados;

			ps.setInt(1, cliente.getId());

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException("No ha sido posible la eliminación del registro");
			}
			ps.close();

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}

	}

}
