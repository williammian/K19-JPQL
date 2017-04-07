package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.Produto;

public class TesteConsultaNativas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
		
		Query nativeQuery = manager.createNativeQuery("SELECT * FROM Produto", Produto.class);
		List<Produto> produtos = nativeQuery.getResultList();
		
		for(Produto p : produtos){
			System.out.println(p.getNome());
		}
		
		manager.close();
		factory.close();
	}

	
}
