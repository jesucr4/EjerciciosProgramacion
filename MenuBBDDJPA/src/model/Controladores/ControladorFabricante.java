package model.Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Coche;
import model.Fabricante;





public class ControladorFabricante {

	
	
	public static List<Fabricante> getAll () throws ErrorBBDDException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM fabricante;", Fabricante.class);
		
		List<Fabricante> fabricantes = (List<Fabricante>) q.getResultList();
		
		for (Fabricante fabri : fabricantes) {
			System.out.println("Fabricante: " + fabri.getId() + " cif: " + fabri.getCif() + " nombre: " + fabri.getNombre());
		}
		
		em.close();
		return fabricantes;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Fabricante fabricante) throws ErrorBBDDException {
		if (get(fabricante.getId()) != null) { // Solo modificar
			almacenarModificado(fabricante);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(fabricante);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return 
	 * @throws ErrorBBDDException
	 */
	public static Fabricante get (int id) throws ErrorBBDDException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		Fabricante fab = (Fabricante) em.find(Fabricante.class, id);
		
		
		em.close();
		return fab;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenarNuevo (Fabricante fab) throws ErrorBBDDException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		
		fab.setCif(fab.getCif());
		fab.setNombre(fab.getNombre());
		
		em.getTransaction().begin();
		em.persist(fab);
		em.getTransaction().commit();
		
		TypedQuery<Fabricante> q = em.createQuery("SELECT f FROM Fabricante as f", Fabricante.class);
		
		List<Fabricante> fabricantes = q.getResultList();
		
		
		
		em.close();

	}
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarModificado (Fabricante fab) throws ErrorBBDDException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();
		int id = fab.getId();

		TypedQuery<Fabricante> q = em.createQuery("SELECT f FROM Fabricante as f where f.id = " + id, Fabricante.class);
		
		List<Fabricante> fabricantes = q.getResultList();
		
		em.getTransaction().begin();
		for (Fabricante fabEnLista : fabricantes) {
			fabEnLista.setCif(fab.getCif());;
			fabEnLista.setNombre(fab.getNombre());
			em.persist(fabEnLista);
		}
		em.getTransaction().commit();
		
		
		em.close();

	}
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void eliminar (Fabricante fab) throws ErrorBBDDException {

		int id = fab.getId();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Fabricante> q = em.createQuery("SELECT f FROM Fabricante as f where f.id = " + id, Fabricante.class);
		
		List<Fabricante> fabricantes = q.getResultList();
		
		em.getTransaction().begin();
		for (Fabricante fabEnLista : fabricantes) {
			em.remove(fabEnLista);
		}
		em.getTransaction().commit();
		
		
		em.close();
	}
	
	
}
