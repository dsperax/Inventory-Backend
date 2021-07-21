package br.com.lojacar8;

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
	private int ID_CATEGORIA;
	private String NOME_CATEGORIA;
	
	public Categoria(String nome) {
		this.NOME_CATEGORIA = nome;
	}
	
	public int getID_CATEGORIA() {
		return ID_CATEGORIA;
	}

	public void setID_CATEGORIA(int iD_CATEGORIA) {
		ID_CATEGORIA = iD_CATEGORIA;
	}

	public String getNome() {
		return NOME_CATEGORIA;
	}

	public void setNome(String nome) {
		this.NOME_CATEGORIA = nome;
	}

	@Override
	public String toString() {
		return "\n [Categoria = " + NOME_CATEGORIA + ", ID = " + ID_CATEGORIA + "]";
	}
}
