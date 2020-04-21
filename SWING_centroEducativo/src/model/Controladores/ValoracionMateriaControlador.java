package model.Controladores;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;
import tema8_AWG_SWING.Gestion.Controlador;


public class ValoracionMateriaControlador extends Controlador {

	// instancia del singleton
	private static ValoracionMateriaControlador instancia = null;

	/**
	 * 
	 */
	public ValoracionMateriaControlador() {
		super(Valoracionmateria.class, "SWING_centroEducativo");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateriaControlador getInstancia() {
		if (instancia == null) {
			instancia = new ValoracionMateriaControlador();
		}
		return instancia;
	}

	public Valoracionmateria find (int id) {
		return (Valoracionmateria) super.find(id);
	}
	
	/**
	 * 
	 */
	public Valoracionmateria findFirst() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT v FROM Valoracionmateria v order by v.id", Valoracionmateria.class);
			Valoracionmateria resultado = (Valoracionmateria) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 */
	public Valoracionmateria findLast() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT v FROM Valoracionmateria v order by v.id desc", Valoracionmateria.class);
			Valoracionmateria resultado = (Valoracionmateria) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public Valoracionmateria findNext(Valoracionmateria v) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT v FROM Valoracionmateria v where v.id > :idActual order by v.id", Valoracionmateria.class);
			q.setParameter("idActual", v.getId());
			Valoracionmateria resultado = (Valoracionmateria) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public Valoracionmateria findPrevious(Valoracionmateria v) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT v FROM Valoracionmateria v where v.id < :idActual order by v.id desc", Valoracionmateria.class);
			q.setParameter("idActual", v.getId());
			Valoracionmateria resultado = (Valoracionmateria) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	
	
	/**
	 * 
	 * @param profesor
	 * @param materia
	 * @param estudiante
	 * @return
	 */
	public Valoracionmateria findByEstudianteAndProfesorAndMateria (Profesor profesor, Materia materia, Estudiante estudiante) {
		Valoracionmateria resultado = null;
		EntityManager em = this.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNativeQuery("Select * from valoracionmateria where idProfesor = ? and "
					+ "idMateria = ? and idEstudiante = ?", Valoracionmateria.class);
			q.setParameter(1, profesor.getId());
			q.setParameter(2, materia.getId());
			q.setParameter(3, estudiante.getId());
			resultado = (Valoracionmateria) q.getSingleResult();
		}
		catch (Exception ex) {
		}
		em.close();
		return resultado;
	}
	
	public static String toString (Valoracionmateria valoracion) {
		return "- Id: " + valoracion.getId() + " -Id profesor: " + valoracion.getProfesor() +
				" -Id estudiante: " + valoracion.getEstudiante() + " --Id materia " + valoracion.getMateria()+
				" -valoración: " + valoracion.getValoracion();
	}
	
}
