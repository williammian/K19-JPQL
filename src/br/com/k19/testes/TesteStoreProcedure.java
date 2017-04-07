package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import br.com.k19.modelo.Produto;

public class TesteStoreProcedure {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
		
		StoredProcedureQuery query = manager.createNamedStoredProcedureQuery("BuscaProdutos");
		query.setParameter("PRECO_MINIMO", 1000.0);
		List<Produto> produtos = query.getResultList();
		
		for(Produto produto : produtos){
			System.out.println("ID: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("-------------------------------");
		}
		
		manager.close();
		factory.close();
	}
}
