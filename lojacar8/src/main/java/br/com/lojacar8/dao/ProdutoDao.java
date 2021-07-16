package br.com.lojacar8.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.lojacar8.Produto;

public class ProdutoDao {

	private EntityManager em;
	
	public ProdutoDao(EntityManager em){
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public void atualiza(Produto produto) {
		this.em.merge(produto);
	}
	
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome"; //:nome poderia ser ?1
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome) //se fosse ?1 seria (1, nome)
				.getResultList(); //método que retorna lista
	}
	
	public List<Produto> buscarPorCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome"; //:nome poderia ser ?1
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome) //se fosse ?1 seria (1, nome)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome"; //:nome poderia ser ?1
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nome) //se fosse ?1 seria (1, nome)
				.getSingleResult(); //método que retorna um unico resultado
	}
}
