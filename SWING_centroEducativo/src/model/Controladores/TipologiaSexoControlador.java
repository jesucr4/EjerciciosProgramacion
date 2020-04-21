package model.Controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Cliente;
import model.Tipologiasexo;
import tema8_AWG_SWING.Gestion.Controlador;
import tema8_AWG_SWING.Gestion.Entidad;



public class TipologiaSexoControlador extends Controlador {

	// instancia del singleton
	private static TipologiaSexoControlador instancia = null;

	/**
	 * 
	 */
	public TipologiaSexoControlador() {
		super(Tipologiasexo.class, "SWING_centroEducativo");
	}

	/**
	 * 
	 * @return
	 */
	public static TipologiaSexoControlador getInstancia() {
		if (instancia == null) {
			instancia = new TipologiaSexoControlador();
		}
		return instancia;
	}
	public Tipologiasexo find (int id) {
		return (Tipologiasexo) super.find(id);
	}
	

	
	/**
	 * 
	 */
	public Tipologiasexo findFirst() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT t FROM Tipologiasexo t order by t.id", Tipologiasexo.class);
			Tipologiasexo resultado = (Tipologiasexo) q.setMaxResults(1).getSingleResult();
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
	public Tipologiasexo findLast() {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT t FROM Tipologiasexo t order by t.id desc", Tipologiasexo.class);
			Tipologiasexo resultado = (Tipologiasexo) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	public Tipologiasexo findNext(Tipologiasexo t) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT t FROM Tipologiasexo t where t.id > :idActual order by t.id", Tipologiasexo.class);
			q.setParameter("idActual", t.getId());
			Tipologiasexo resultado = (Tipologiasexo) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	public Tipologiasexo findPrevious(Tipologiasexo t) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT t FROM Tipologiasexo t where t.id < :idActual order by t.id desc", Tipologiasexo.class);
			q.setParameter("idActual", t.getId());
			Tipologiasexo resultado = (Tipologiasexo) q.setMaxResults(1).getSingleResult();
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
	public List<Tipologiasexo> findAllTipologiasSexo () {
		List<Tipologiasexo> entities = new ArrayList<Tipologiasexo>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM tipologiasexo", Tipologiasexo.class);
			entities = (List<Tipologiasexo>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	
	public static String toString (Tipologiasexo sexo) {
		return " -Id: " + sexo.getId() + " -descripción: " + sexo.getDescripcion() ;
	}
		
}
