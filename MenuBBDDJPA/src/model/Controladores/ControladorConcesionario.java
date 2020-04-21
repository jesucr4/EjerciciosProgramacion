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

import model.Concesionario;
import model.Fabricante;





public class ControladorConcesionario {

	
	
	public static List<Concesionario> getAll () throws ErrorBBDDException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM concesionario;", Concesionario.class);
		
		List<Concesionario> concesionarios = (List<Concesionario>) q.getResultList();
		
		for (Concesionario conce : concesionarios) {
			System.out.println("Concesionario: " + conce.getId() + " cif: " + conce.getCif() + " nombre: " + conce.getNombre() +
					 " localidad: "+conce.getLocalidad());
		}
		
		em.close();
		return concesionarios;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Concesionario concesionario) throws ErrorBBDDException {
		if (get(concesionario.getId()) != null) { // Solo modificar
			almacenarModificado(concesionario);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(concesionario);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Concesionario get (int id) throws ErrorBBDDException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		Concesionario con = (Concesionario) em.find(Concesionario.class, id);
		
		
		em.close();
		return con;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Concesionario con) throws ErrorBBDDException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		
		con.setCif(con.getCif());
		con.setNombre(con.getNombre());
		con.setLocalidad(con.getLocalidad());
		
		em.getTransaction().begin();
		em.persist(con);
		em.getTransaction().commit();
		
		TypedQuery<Concesionario> q = em.createQuery("SELECT C FROM Concesionario as c", Concesionario.class);
		
		List<Concesionario> concesionarios = q.getResultList();
		
		
		
		em.close();


	}
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarModificado (Concesionario concesionario) throws ErrorBBDDException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();
		int id = concesionario.getId();

		TypedQuery<Concesionario> q = em.createQuery("SELECT c FROM Concesionario as c where c.id = " + id, Concesionario.class);
		
		List<Concesionario> concesionarios = q.getResultList();
		
		em.getTransaction().begin();
		for (Concesionario conEnLista : concesionarios) {
			conEnLista.setCif(concesionario.getCif());;
			conEnLista.setNombre(concesionario.getNombre());
			conEnLista.setLocalidad(concesionario.getLocalidad());
			em.persist(conEnLista);
		}
		em.getTransaction().commit();
		
		
		em.close();

	}
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void eliminar (Concesionario con) throws ErrorBBDDException {

		int id = con.getId();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Concesionario> q = em.createQuery("SELECT c FROM Concesionario as c where c.id = " + id, Concesionario.class);
		
		List<Concesionario> concesionarios = q.getResultList();
		
		em.getTransaction().begin();
		for (Concesionario conEnLista : concesionarios) {
			em.remove(conEnLista);
		}
		em.getTransaction().commit();
		
		
		em.close();
	
	}
}
