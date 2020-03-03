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

import tema7_BasesDatos.MenuBBDD.Modelo.Coche;
import tema7_BasesDatos.MenuBBDD.Modelo.Venta;



public class ControladorCoche extends ControladorBBDD {

	public static List<Coche> getAll() throws ErrorBBDDException, ImposibleConectarException, ParseException {
		List<Coche> car = new ArrayList<Coche>();

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from coche");

			while (rs.next()) {
				Coche coch = new Coche();
				coch.setId(rs.getInt("id"));
				coch.setIdFabricante(rs.getInt("idfabricante"));
				coch.setBastidor(rs.getString("bastidor"));
				coch.setModelo(rs.getString("modelo"));
				coch.setColor(rs.getString("color"));
				car.add(coch);
			}

			s.close();

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}
		return car;
	}

	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static void almacenar(Coche car) throws ErrorBBDDException, ParseException {
		if (get(car.getId()) != null) { // Solo modificar
			almacenarModificado(car);
		} else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(car);
		}
	}

	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static Coche get(int id) throws ErrorBBDDException, ParseException {
		Connection conn = null;
		Coche car = null;
		System.out.println(id);
		try {
			conn = ConnectionManagerV2.getConexion();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from coche where id = " + id);

			if (rs.next()) {
				car = new Coche();
				car.setId(rs.getInt("id"));
				car.setIdFabricante(rs.getInt("idfabricante"));
				car.setBastidor(rs.getString("bastidor"));
				car.setModelo(rs.getString("modelo"));
				car.setColor(rs.getString("color"));
			}
			s.close();

		} catch (SQLException | ImposibleConectarException e) {
			throw new ErrorBBDDException(e);
		}
		return car;
	}

	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo(Coche car) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("INSERT INTO coche (id, idfabricante, bastidor, modelo, color) VALUES  (?, ?, ?, ?, ?)");
			int registrosInsertados;

			ps.setInt(1, nextIdEnTabla(conn, "coche"));
			ps.setInt(2, car.getIdFabricante());
			ps.setString(3, car.getBastidor());
			ps.setString(4, car.getModelo());
			ps.setString(5,  car.getColor());
			
			

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
	private static void almacenarModificado(Coche car) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("update coche set idfabricante = ?, bastidor = ?, modelo = ?, color = ? where id = ?");
			int registrosInsertados;

			ps.setInt(1, car.getIdFabricante());
			ps.setString(2, car.getBastidor());
			ps.setString(3, car.getModelo());
			ps.setString(4,  car.getColor());
			ps.setInt(5, car.getId());
			

			
			
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
	public static void eliminar(Coche car) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();

			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("delete from coche where id = ?");
			int registrosInsertados;

			ps.setInt(1, car.getId());

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
