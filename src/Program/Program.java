package Program;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Pessoa;

public class Program {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em =emf.createEntityManager();
				
		for (int i=0; i<100; i++) {
			Pessoa p1 = new Pessoa(null, "jo�o da silva", "joao@gmail.com");
			Pessoa p2 = new Pessoa(null, "jos�", "ze@gmail.com");
			Pessoa p3 = new Pessoa(null, "maria", "maria@gmail.com");
			em.getTransaction().begin();
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
		System.out.println("Pronto");
	}
}
