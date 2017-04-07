package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteConsultaObjetosComuns {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<String> query = manager.createQuery("select livro.nome from Livro livro", String.class);
		List<String> nomes = query.getResultList();
		
		for(String nome : nomes){
			System.out.println("Livro: " + nome);
		}
		
		manager.close();
		factory.close();
	}
}
