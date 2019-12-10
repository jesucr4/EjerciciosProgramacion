package entornos_Desarrollo_Base_de_Datos;

import java.io.Serializable;
import java.util.Date;

/**
 * Model class of Elaboran.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Elaboran implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Profesores. */
	private Profesores profesores;

	/** Practicas. */
	private Practicas practicas;

	/** Fecha. */
	private Date fecha;

	/**
	 * Constructor.
	 */
	public Elaboran() {
	}

	/**
	 * Set the Profesores.
	 * 
	 * @param profesores
	 *            Profesores
	 */
	public void setProfesores(Profesores profesores) {
		this.profesores = profesores;
	}

	/**
	 * Get the Profesores.
	 * 
	 * @return Profesores
	 */
	public Profesores getProfesores() {
		return this.profesores;
	}

	/**
	 * Set the Practicas.
	 * 
	 * @param practicas
	 *            Practicas
	 */
	public void setPracticas(Practicas practicas) {
		this.practicas = practicas;
	}

	/**
	 * Get the Practicas.
	 * 
	 * @return Practicas
	 */
	public Practicas getPracticas() {
		return this.practicas;
	}

	/**
	 * Set the Fecha.
	 * 
	 * @param fecha
	 *            Fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Get the Fecha.
	 * 
	 * @return Fecha
	 */
	public Date getFecha() {
		return this.fecha;
	}


}
