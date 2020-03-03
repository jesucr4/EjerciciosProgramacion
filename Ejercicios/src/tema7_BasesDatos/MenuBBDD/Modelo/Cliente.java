package tema7_BasesDatos.MenuBBDD.Modelo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Cliente {
	SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	int id;
	String nombre;
	String apellidos;
	String localidad;
	String dniNie;
	String fechaNac;
	boolean activo;
	
	

	public Cliente() {
	}

	public Cliente(int id, String nombre, String apellidos, String localidad, String dniNie,
			String fechaNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.localidad = localidad;
		this.dniNie = dniNie;
		this.fechaNac = fechaNac;
		this.activo = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the dniNie
	 */
	public String getDniNie() {
		return dniNie;
	}

	/**
	 * @param dniNie the dniNie to set
	 */
	public void setDniNie(String dniNie) {
		this.dniNie = dniNie;
	}

	/**
	 * @return the fechaNac
	 */
	public String getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param date the fechaNac to set
	 * @throws ParseException 
	 */
	public void setFechaNac(Date date) throws ParseException {
		if ( date != null) {
		this.fechaNac = sdf.format(date);
		}
	}

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", localidad=" + localidad
				+ ", dniNie=" + dniNie + ", fechaNac=" + fechaNac + ", activo=" + activo + "]";
	}

	

}