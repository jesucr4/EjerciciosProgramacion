package model.Controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Cliente;
import model.Estudiante;
import model.Profesor;
import tema8_AWG_SWING.Gestion.Controlador;
import tema8_AWG_SWING.Gestion.Entidad;


public class ProfesorControlador extends Controlador {

	// instancia del singleton
	private static ProfesorControlador instancia = null;

	/**
	 * 
	 */
	public ProfesorControlador() {
		super(Profesor.class, "SWING_centroEducativo");
	}

	/**
	 * 
	 * @return
	 */
	public static ProfesorControlador getInstancia() {
		if (instancia == null) {
			instancia = new ProfesorControlador();
		}
		return instancia;
	}
	public Profesor find (int id) {
		return (Profesor) super.find(id);
	}

	/**
	 * 
	 */
	public Profesor findFirst() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT p FROM Profesor p order by p.id", Profesor.class);
			Profesor resultado = (Profesor) q.setMaxResults(1).getSingleResult();
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
	public Profesor findLast() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT p FROM Profesor p order by p.id desc", Cliente.class);
			Profesor resultado = (Profesor) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	public Profesor findNext(Profesor p) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT p FROM Profesor p where p.id > :idActual order by p.id", Profesor.class);
			q.setParameter("idActual", p.getId());
			Profesor resultado = (Profesor) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	public Profesor findPrevious(Profesor p) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT p FROM Profesor p where p.id < :idActual order by p.id desc", Profesor.class);
			q.setParameter("idActual", p.getId());
			Profesor resultado = (Profesor) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Profesor> findAllProfesores () {
		List<Profesor> entities = new ArrayList<Profesor>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
			entities = (List<Profesor>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	
	public static String toString (Profesor profesor) {
		return " -Id: " + profesor.getId() + " -nombre: " + profesor.getNombre() +
				" -primer apellido: " + profesor.getApellido1() + " -segundo apellido: " + profesor.getApellido2() +
				" -DNI: " +profesor.getDni() + " -direccion: " + profesor.getDireccion() + 
				" -email: " + profesor.getEmail() + " -telefono: " + profesor.getTelefono() +
				" -sexo alumno: " + profesor.getTipologiasexo();	
		}
}
