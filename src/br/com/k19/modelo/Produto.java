package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQuery(
		name="BuscaProdutos",
		resultClasses = Produto.class,
		procedureName = "BUSCA_PRODUTOS",
		parameters = {
			@StoredProcedureParameter(
					mode=ParameterMode.IN,
					name="PRECO_MINIMO",
					type=Double.class
			)
		}
)
@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private Double preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
