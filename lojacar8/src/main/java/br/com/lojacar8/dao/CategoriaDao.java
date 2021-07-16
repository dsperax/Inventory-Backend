package br.com.lojacar8.dao;

import javax.persistence.EntityManager;

import br.com.lojacar8.Categoria;

public class CategoriaDao {

	private EntityManager em;
	
	public CategoriaDao(EntityManager em){
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria){
		this.em.persist(categoria);
	}
	
	public void atualiza(Categoria categoria){
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria){
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
}
