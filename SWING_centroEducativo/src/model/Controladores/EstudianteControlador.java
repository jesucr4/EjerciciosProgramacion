package model.Controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import model.Estudiante;
import model.Tipologiasexo;
import tema8_AWG_SWING.Gestion.Controlador;




public class EstudianteControlador extends Controlador {

	// instancia del singleton
	private static EstudianteControlador instancia = null;

	/**
	 * 
	 */
	public EstudianteControlador() {
		super(Estudiante.class, "SWING_centroEducativo");
	}

	/**
	 * 
	 * @return
	 */
	public static EstudianteControlador getInstancia() {
		if (instancia == null) {
			instancia = new EstudianteControlador();
		}
		return instancia;
	}
	
	public Estudiante find (int id) {
		return (Estudiante) super.find(id);
	}

	/**
	 * 
	 */
	public Estudiante findFirst() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT e FROM Estudiante e order by e.id", Estudiante.class);
			Estudiante resultado = (Estudiante) q.setMaxResults(1).getSingleResult();
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
	public Estudiante findLast() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT e FROM Estudiante e order by e.id desc", Estudiante.class);
			Estudiante resultado = (Estudiante) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public Estudiante findNext(Estudiante e) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT e FROM Estudiante e where e.id > :idActual order by e.id", Estudiante.class);
			q.setParameter("idActual", e.getId());
			Estudiante resultado = (Estudiante) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public Estudiante findPrevious(Estudiante e) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT e FROM Estudiante e where e.id < :idActual order by e.id desc", Estudiante.class);
			q.setParameter("idActual", e.getId());
			Estudiante resultado = (Estudiante) q.setMaxResults(1).getSingleResult();
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
	public List<Estudiante> findAllEstudiantes() {
		List<Estudiante> resultado = new ArrayList<Estudiante>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		
		try {
			Query q = em.createNativeQuery("Select * from estudiante", Estudiante.class);
			resultado = (List<Estudiante>) q.getResultList();
		} catch (Exception e) {
		}
		em.close();
		return resultado;
	}
	
	public static String toString (Estudiante estudiante) {
		return " -Id: " + estudiante.getId() + " -nombre: " + estudiante.getNombre() +
				" -primer apellido: " + estudiante.getApellido1() + " -segundo apellido: " + estudiante.getApellido2() +
				" -DNI: " +estudiante.getDni() + " -direccion: " + estudiante.getDireccion() + 
				" -email: " + estudiante.getEmail() + " -telefono: " + estudiante.getTelefono() +
				" -sexo alumno: " + estudiante.getTipologiasexo();	
		}

	
}
