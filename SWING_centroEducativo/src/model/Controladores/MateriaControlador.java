package model.Controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Cliente;
import model.Materia;
import model.Tipologiasexo;
import tema8_AWG_SWING.Gestion.Controlador;
import tema8_AWG_SWING.Gestion.Entidad;



public class MateriaControlador extends Controlador {

	// instancia del singleton
	private static MateriaControlador instancia = null;

	/**
	 * 
	 */
	public MateriaControlador() {
		super(Materia.class, "SWING_centroEducativo");
	}

	/**
	 * 
	 * @return
	 */
	public static MateriaControlador getInstancia() {
		if (instancia == null) {
			instancia = new MateriaControlador();
		}
		return instancia;
	}

	public Materia find (int id) {
		return (Materia) super.find(id);
	}
	/**
	 * 
	 */
	public Materia findFirst() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT m FROM Materia m order by m.id", Materia.class);
			Materia resultado = (Materia) q.setMaxResults(1).getSingleResult();
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
	public Materia findLast() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT m FROM Materia m order by m.id desc", Materia.class);
			Materia resultado = (Materia) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public Materia findNext(Materia m) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT m FROM Materia m where m.id > :idActual order by m.id", Materia.class);
			q.setParameter("idActual", m.getId());
			Materia resultado = (Materia) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public Materia findPrevious(Materia m) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT m FROM Materia m where m.id < :idActual order by m.id desc", Materia.class);
			q.setParameter("idActual", m.getId());
			Materia resultado = (Materia) q.setMaxResults(1).getSingleResult();
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
	public List<Materia> findAllMaterias () {
		List<Materia> entities = new ArrayList<Materia>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);
			entities = (List<Materia>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	
	public static String toString (Materia materia) {
		return " -Id: " + materia.getId() + " -nombre: " + materia.getNombre()+
				" -acronimo: " + materia.getAcronimo() + " -curso: " + materia.getCurso();
	}
		
}
