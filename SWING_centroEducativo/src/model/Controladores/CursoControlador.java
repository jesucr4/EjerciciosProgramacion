package model.Controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import model.Curso;
import model.Tipologiasexo;
import tema8_AWG_SWING.Gestion.Controlador;




public class CursoControlador extends Controlador {

	// instancia del singleton
	private static CursoControlador instancia = null;

	/**
	 * 
	 */
	public CursoControlador() {
		super(Curso.class, "SWING_centroEducativo");
	}

	/**
	 * 
	 * @return
	 */
	public static CursoControlador getInstancia() {
		if (instancia == null) {
			instancia = new CursoControlador();
		}
		return instancia;
	}
	public Curso find (int id) {
		return (Curso)super.find(id);
	}

	/**
	 * 
	 */
	public Curso findFirst() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Curso c order by c.id", Curso.class);
			Curso resultado = (Curso) q.setMaxResults(1).getSingleResult();
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
	public Curso findLast() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Curso c order by c.id desc", Curso.class);
			Curso resultado = (Curso) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	/**
	 * 
	 * @param c
	 * @return
	 */
	public Curso findNext(Curso c) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Curso c where c.id > :idActual order by c.id", Curso.class);
			q.setParameter("idActual", c.getId());
			Curso resultado = (Curso) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	/**
	 * 
	 * @param c
	 * @return
	 */
	public Curso findPrevious(Curso c) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Curso c where c.id < :idActual order by c.id desc", Curso.class);
			q.setParameter("idActual", c.getId());
			Curso resultado = (Curso) q.setMaxResults(1).getSingleResult();
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
	public List<Curso> findAllCursos () {
		List<Curso> entities = new ArrayList<Curso>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM curso", Curso.class);
			entities = (List<Curso>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	public static String toString (Curso curso) {
		return " -Id: " + curso.getId() + " -descripción: " + curso.getDescripcion() ;
	}
}
