package prueba;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.entidad.Cliente;
import modelo.entidad.Direccion;

public class _01_Consultas {

	public static EntityManagerFactory emf = null;

	public static EntityManager em = null;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		emf = Persistence.createEntityManagerFactory("PruebaJPARelaciones");
		
		iniciarBBDD();
		
		em = emf.createEntityManager();

		// Listamos todos los clientes
		// Notese que NO se pone la tabla "clientes" sino la entidad
		// Cliente
		System.out.println("===================================");
		//Con query podemos crear querys JPQL genericas
		Query query = em.createQuery("Select c from Cliente c");
		List<Cliente> list = query.getResultList();
		System.out.println("==== listado de clientes ====");
		listarClientes(list);
		
		System.out.println("===================================");
		query = em.createQuery("SELECT cli FROM Cliente cli WHERE cli.nombre LIKE '%Burns%'");
		list = query.getResultList();
		System.out.println("==== listado de clientes burns====");
		listarClientes(list);
		
		System.out.println("===================================");
		query = em.createQuery("SELECT cli.nombre FROM Cliente cli WHERE cli.nombre LIKE '%Burns%'");
		List<String> listaNombres = query.getResultList();
		System.out.println("==== listado de nombres burns====");
		System.out.println(listaNombres);
		
		System.out.println("===================================");
		query = em.createQuery("SELECT cli.nombre, cli.telefono FROM Cliente cli WHERE cli.nombre LIKE '%Burns%'");
		List<Object[]> resultados = query.getResultList();
		System.out.println("==== listado de nombres y telefonos burns====");
		for (Object[] p : resultados) {
			System.out.println(p[0] + " - " + p[1]);//la posicion 0 tiene el nombre y la 1 el telefono
		}
				
		System.out.println("===================================");
		//Con TypedQuery podemos crear queries con valores genericos
		//o parametrizados
		TypedQuery<Long> queryTyped = em.createQuery("SELECT count(c) FROM Cliente c", Long.class);
		//Con getSingleResult() solo nos devuelve un resultado
		//Ojo, solo usar si sabes que te va a devolver un único resultado
		Long numeroClientes = queryTyped.getSingleResult();
		System.out.println("Numero de clientes: " + numeroClientes);
		
		System.out.println("===================================");
		
		em.close();
		emf.close();
	}

	/**
	 * Metodo que inicia los datos de la bbdd
	 */
	private static void iniciarBBDD() {

		Cliente c = new Cliente(null, "Montgomery Burns", "555", null);
		c.setFechaNacimiento(new Date());// fecha de hoy
		Direccion d = new Direccion();
		d.setTipoVia("Calle");
		d.setNombreVia("Portugalete");
		d.setCiudad("Madrid");

		c.setDireccion(d);

		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		// salvamos y observamos como la direccion se ha guardado
		// dentro de la tabla clientes(ya que direccion esta embebida)
		em.persist(c);
		
		c = new Cliente(null, "El hijo de Burns", "666", null);
		em.persist(c);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void listarClientes(List<Cliente> listaClientes) {
		for(Cliente c : listaClientes) {
			System.out.println("Cliente-> nombre: " + c.getNombre() + "; Telefono: " + c.getTelefono());
		}
	}
}
