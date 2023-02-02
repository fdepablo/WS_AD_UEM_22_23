package prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _02_ModificarPersonaJPA {
	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
		
		Persona persona = new Persona();
		persona.setId(1);//por defecto la modificacion es sobre clave primaria
		persona.setNombre("Chiquito de la calzada de sevilla de tormes");
		persona.setEdad(82);
		persona.setPeso(120);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		Persona pManaged = em.merge(persona);
		System.out.println(em.contains(persona));
		System.out.println(em.contains(pManaged));
		//em.detach(pManaged);
		et.commit();
		
		em.close();
		
		System.out.println("Fin de modificar persona");
	}
}
