package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); // exemplo-jpa é o nome dado em: src/test/resources
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			Pessoa p = em.find(Pessoa.class, 2);
			em.remove(p);
			System.out.println(p);
			System.out.println("Pronto!");
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
