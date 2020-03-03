package tema7_BasesDatos.MenuBBDD.Modelo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Venta {

	int id;
	int idCliente;
	int idConcesionario;
	int idCoche;
	String fecha;
	String precioVenta;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public Venta() {
	}

	public Venta(int id, int idCliente, int idConcesionario, int idCoche, String fechaNac, String precioVenta) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idConcesionario = idConcesionario;
		this.idCoche = idCoche;
		this.fecha = fechaNac;
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the idConcesionario
	 */
	public int getIdConcesionario() {
		return idConcesionario;
	}

	/**
	 * @param idConcesionario the idConcesionario to set
	 */
	public void setIdConcesionario(int idConcesionario) {
		this.idConcesionario = idConcesionario;
	}

	/**
	 * @return the idCoche
	 */
	public int getIdCoche() {
		return idCoche;
	}

	/**
	 * @param idCoche the idCoche to set
	 */
	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	/**
	 * @return the fechaNac
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFecha(Date date) throws ParseException {
		this.fecha = sdf.format(date);
	}

	/**
	 * @return the precioVenta
	 */
	public String getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the sdf
	 */
	public SimpleDateFormat getSdf() {
		return sdf;
	}

	/**
	 * @param sdf the sdf to set
	 */
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", idCliente=" + idCliente + ", idConcesionario=" + idConcesionario + ", idCoche="
				+ idCoche + ", fechaNac=" + fecha + ", precioVenta=" + precioVenta + "]";
	}

	/**
	 * @param id
	 * @param idCliente
	 * @param idConcesionario
	 * @param idCoche
	 * @param fechaNac
	 * @param precioVenta
	 */
	
}
