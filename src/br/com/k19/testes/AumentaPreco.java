package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AumentaPreco {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("UPDATE Produto p SET p.preco = p.preco * 1.1");
		query.executeUpdate();
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
	
}
