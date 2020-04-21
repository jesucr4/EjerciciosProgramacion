package model.Controladores;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Coche;
import model.Concesionario;





public class ControladorCoche {

	public static List<Coche> getAll() throws ErrorBBDDException, ImposibleConectarException, ParseException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM coche;", Coche.class);
		
		List<Coche> coches = (List<Coche>) q.getResultList();
		
		for (Coche co : coches) {
			System.out.println("Coche: " + co.getId() + " id Fabricante: " + co.getFabricante().getId() + 
					" bastidor: " + co.getBastidor() + " modelo " + co.getModelo() + " color " + co.getColor());
		}
		
		em.close();
		return coches;
	}

	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static void almacenar(Coche car) throws ErrorBBDDException, ParseException {
		if (get(car.getId()) != null) { // Solo modificar
			almacenarModificado(car);
		} else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(car);
		}
	}

	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static Coche get(int id) throws ErrorBBDDException, ParseException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		Coche car = (Coche) em.find(Coche.class, id);
		
		
		em.close();
		return car;
	}

	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo(Coche car) throws ErrorBBDDException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		
		car.setFabricante(car.getFabricante());
		car.setBastidor(car.getBastidor());
		car.setModelo(car.getModelo());
		car.setColor(car.getColor());
		
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		
		TypedQuery<Coche> q = em.createQuery("SELECT C FROM Coche as c", Coche.class);
		
		List<Coche> coches = q.getResultList();
		
		
		
		em.close();
	}

	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarModificado(Coche car) throws ErrorBBDDException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();
		int id = car.getId();

		TypedQuery<Coche> q = em.createQuery("SELECT c FROM Coche as c where c.id = " + id, Coche.class);
		
		List<Coche> coches = q.getResultList();
		
		em.getTransaction().begin();
		for (Coche carEnLista : coches) {
			carEnLista.setBastidor(car.getBastidor());
			carEnLista.setModelo(car.getModelo());
			carEnLista.setColor(car.getColor());
			em.persist(carEnLista);
		}
		em.getTransaction().commit();
		
		
		em.close();

	}

	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void eliminar(Coche car) throws ErrorBBDDException {

		int id = car.getId();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Coche> q = em.createQuery("SELECT c FROM Coche as c where c.id = " + id, Coche.class);
		
		List<Coche> coches = q.getResultList();
		
		em.getTransaction().begin();
		for (Coche carEnLista : coches) {
			em.remove(carEnLista);
		}
		em.getTransaction().commit();
		
		
		em.close();

	}

}
