package br.com.lojacar.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.lojacar.Categoria;
import br.com.lojacar.Produto;
import br.com.lojacar.dao.CategoriaDao;
import br.com.lojacar.dao.ProdutoDao;
import br.com.lojacar.util.JPAUtil;

public class TesteCadastro {
	
	public static void main(String[] args) {
		CadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		Produto p2 = produtoDao.buscarPorId(2l);
		System.out.println(p2.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(ps -> System.out.println(ps.getNome()));
		
		List<Produto> todosComNome = produtoDao.buscarPorNome("Samsung A71");
		todosComNome.forEach(ps -> System.out.println(ps.getNome()));
		
		List<Produto> todosComNomeCategoria = produtoDao.buscarPorCategoria("CELULARES");
		todosComNomeCategoria.forEach(ps -> System.out.println(ps.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Samsung M51");
		System.out.println("Preço M51: " + precoDoProduto);
	}

	private static void CadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");		
		Produto m51 = new Produto("Samsung M51", "Excelente modelo com 7000 mAh de bateria.", new BigDecimal("1615.14"), celulares);
		Produto a71 = new Produto("Samsung A71", "Modelo performátco com 4000 mAh de bateria.", new BigDecimal("1715.14"), celulares);
	
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();//inicia a transação
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(m51); //faz insert na tabela do banco
		produtoDao.cadastrar(a71);
		
		em.getTransaction().commit();//commit na transação no banco de dados.
		em.close();
	}
}