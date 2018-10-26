package Program;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Pessoa;

public class Program {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em =emf.createEntityManager();
		Pessoa p1 = new Pessoa(null, "joão da silva", "joao@gmail.com");
		Pessoa p2 = new Pessoa(null, "josé", "ze@gmail.com");
		Pessoa p3 = new Pessoa(null, "maria", "maria@gmail.com");
		
		for (int i=0; i<10000; i++) {
			em.getTransaction().begin();
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.getTransaction().commit();
		}
		System.out.println("Pronto");
	}
}
