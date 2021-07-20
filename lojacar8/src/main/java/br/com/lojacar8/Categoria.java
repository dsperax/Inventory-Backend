package br.com.lojacar8;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal ID_CATEGORIA;
	private String NOME_CATEGORIA;
	
	public Categoria() {
		
	}
	
	public BigDecimal getID_CATEGORIA() {
		return ID_CATEGORIA;
	}

	public Categoria(String nome) {
		this.NOME_CATEGORIA = nome;
	}

	public String getNome() {
		return NOME_CATEGORIA;
	}

	public void setNome(String nome) {
		this.NOME_CATEGORIA = nome;
	}
}
