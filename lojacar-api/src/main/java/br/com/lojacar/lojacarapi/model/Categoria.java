package br.com.lojacar.lojacarapi.model;

public class Categoria {
	
	private long id;
	private String nome;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
