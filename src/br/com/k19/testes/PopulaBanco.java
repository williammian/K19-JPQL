package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class PopulaBanco {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Livro livro1 = new Livro();
		livro1.setNome("Livro 1");
		livro1.setPreco(20.6);
		manager.persist(livro1);
		
		Livro livro2 = new Livro();
		livro2.setNome("Livro 2");
		livro2.setPreco(16.9);
		manager.persist(livro2);
		
		Livro livro3 = new Livro();
		livro3.setNome("Livro 3");
		livro3.setPreco(30.7);
		manager.persist(livro3);
		
		Livro livro4 = new Livro();
		livro4.setNome("Livro 4");
		livro4.setPreco(32.1);
		manager.persist(livro4);
		
		Livro livro5 = new Livro();
		livro5.setNome("Livro 5");
		livro5.setPreco(12.3);
		manager.persist(livro5);
		
		Autor autor1 = new Autor();
		autor1.setNome("Patrick Cullen");
		autor1.getLivros().add(livro2);
		autor1.getLivros().add(livro4);
		manager.persist(autor1);
		
		Autor autor2 = new Autor();
		autor2.setNome("Fraser Seitel");
		autor2.getLivros().add(livro3);
		manager.persist(autor2);
		
		Autor autor3 = new Autor();
		autor3.setNome("Al Ries");
		autor3.getLivros().add(livro1);
		manager.persist(autor3);
		
		Autor autor4 = new Autor();
		autor4.setNome("Jack Trout");
		autor4.getLivros().add(livro1);
		autor4.getLivros().add(livro2);
		autor4.getLivros().add(livro5);
		manager.persist(autor4);
		
		Autor autor5 = new Autor();
		autor5.setNome("Steve Rivkin");
		autor5.getLivros().add(livro2);
		autor5.getLivros().add(livro3);
		autor5.getLivros().add(livro5);
		manager.persist(autor5);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
