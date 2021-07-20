package br.com.lojacar8;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal ID_PRODUTO;
	private String NOME_PRODUTO;
	private String DESCRICAO_PRODUTO;
	private Double PRECO_PRODUTO;
	@ManyToOne //muitos produtos tem uma categoria
	private Categoria categoria;
	
	public Produto() {
		
	}

	public Produto(String nome, String descricao, Double preco, Categoria categoria) {
		this.NOME_PRODUTO = nome;
		this.DESCRICAO_PRODUTO = descricao;
		this.PRECO_PRODUTO = preco;
		this.categoria = categoria;
	}
	
	
	public BigDecimal getID_PRODUTO() {
		return ID_PRODUTO;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getNome() {
		return NOME_PRODUTO;
	}

	public void setNome(String nome) {
		this.NOME_PRODUTO = nome;
	}

	public String getDescricao() {
		return DESCRICAO_PRODUTO;
	}

	public void setDescricao(String descricao) {
		this.DESCRICAO_PRODUTO = descricao;
	}

	public Double getPreco() {
		return PRECO_PRODUTO;
	}

	public void setPreco(Double preco) {
		this.PRECO_PRODUTO = preco;
	}


}