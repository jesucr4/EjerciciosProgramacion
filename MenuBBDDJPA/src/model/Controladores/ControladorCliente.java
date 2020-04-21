package model.Controladores;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Cliente;





public class ControladorCliente  {

	
	
	public static List<Cliente> getAll () throws ErrorBBDDException, ParseException, ImposibleConectarException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM cliente;", Cliente.class);
		
		List<Cliente> clientes = (List<Cliente>) q.getResultList();
		
		for (Cliente cli : clientes) {
			System.out.println("Cliente: " + cli.getId() + " nombre: " + cli.getNombre() + " apellidos: " + cli.getApellidos()  +
					 " localidad: "+ cli.getLocalidad() + " dniNie " + cli.getDniNie() + " fecha nacimiento" + cli.getFechaNac());
		}
		
		em.close();
		
		return clientes;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static void almacenar (Cliente cliente) throws ErrorBBDDException, ParseException {
		if (get(cliente.getId()) != null) { // Solo modificar
			almacenarModificado(cliente);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(cliente);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	public static Cliente get (int id) throws ErrorBBDDException, ParseException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		Cliente cli= (Cliente) em.find(Cliente.class, id);
		
		
		em.close();
		
		return cli;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Cliente cliente) throws ErrorBBDDException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		
		
		cliente.setNombre(cliente.getNombre());
		cliente.setApellidos(cliente.getApellidos());
		cliente.setLocalidad(cliente.getLocalidad());
		cliente.setDniNie(cliente.getDniNie());
		cliente.setFechaNac(cliente.getFechaNac());
		cliente.setActivo(true);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		TypedQuery<Cliente> q = em.createQuery("SELECT C FROM Cliente as c", Cliente.class);
		
		List<Cliente> clientes = q.getResultList();
		
		
		
		em.close();

	}
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarModificado (Cliente cliente) throws ErrorBBDDException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();
		int id = cliente.getId();

		TypedQuery<Cliente> q = em.createQuery("SELECT c FROM Cliente as c where c.id = " + id, Cliente.class);
		
		List<Cliente> clientes = q.getResultList();
		
		em.getTransaction().begin();
		for (Cliente cliEnLista : clientes) {
			
			cliEnLista.setNombre(cliente.getNombre());
			cliEnLista.setApellidos(cliente.getApellidos());
			cliEnLista.setLocalidad(cliente.getLocalidad());
			cliEnLista.setDniNie(cliente.getDniNie());
			cliEnLista.setFechaNac(cliente.getFechaNac());
			cliEnLista.setActivo(true);
			em.persist(cliEnLista);
		}
		em.getTransaction().commit();
		
		
		em.close();

	}
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void eliminar (Cliente cliente) throws ErrorBBDDException {

		int id = cliente.getId();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PruebaJesusJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Cliente> q = em.createQuery("SELECT c FROM Cliente as c where c.id = " + id, Cliente.class);
		
		List<Cliente> clientes = q.getResultList();
		
		em.getTransaction().begin();
		for (Cliente cliEnLista : clientes) {
			em.remove(cliEnLista);
		}
		em.getTransaction().commit();
		
		
		em.close();

	}
	
	
}
