package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import tema8_AWG_SWING.Gestion.Entidad;


/**
 * The persistent class for the valoracionmateria database table.
 * 
 */
@Entity
@NamedQuery(name="Valoracionmateria.findAll", query="SELECT v FROM Valoracionmateria v")
public class Valoracionmateria extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private float valoracion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date Fecha;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEstudiante")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Materia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMateria")
	private Materia materia;

	//bi-directional many-to-one association to Profesor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProfesor")
	private Profesor profesor;

	public Valoracionmateria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Date getFecha() {
		return this.Fecha;
	}

	public void setFecha(Date Fecha) {
		this.Fecha = Fecha;
	}
	


}