package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteConsultaLivroPrecoMedio {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<Double> query = manager.createQuery("select AVG(livro.preco) from Livro livro", Double.class);
		Double precoMedio = query.getSingleResult();
		
		System.out.println("Pre�o M�dio: " + precoMedio);
		
		manager.close();
		factory.close();
	}
}
