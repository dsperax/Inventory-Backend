package br.com.lojacar.ambiente;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.lojacar.Categoria;
import br.com.lojacar.Produto;
import br.com.lojacar.dao.CategoriaDao;
import br.com.lojacar.dao.ProdutoDao;
import br.com.lojacar.util.JPAUtil;

public class Ambiente {
	
	public static void main(String[] args) {
		inicializacaoEstoque();	
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		
		Categoria vidros = new Categoria("VIDROS");
		Produto retrovisorFusionD = new Produto("RETROVISOR FUSION D", "RETROVISOR COR PRETA LADO DIREITO FORD FUSION 19/19", new BigDecimal("570"), vidros);
						
		em.getTransaction().begin();//inicia a transação
		
		categoriaDao.cadastrar(vidros);
		produtoDao.cadastrar(retrovisorFusionD);
		
		em.getTransaction().commit();//commit na transação no banco de dados.
		
		buscaTudo(produtoDao);
		
		em.close();
		
		
		//buscaPeloNome("PARA-BRISA RANGER");

		//buscaProdutosNaCategoria("VIDROS");
		
		//buscaPrecoComNome("RETROVISOR COROLLA D");
		
	}
	
	
	private static void buscaPrecoComNome(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome(nome);
		System.out.println("Produto: " + nome + ", Preço do produto: " + precoDoProduto);
	}
	
	private static void buscaProdutosNaCategoria(String categoria) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		List<Produto> todosComNomeCategoria = produtoDao.buscarPorCategoria(categoria);
		todosComNomeCategoria.forEach(ps -> System.out.println(ps.getDescricao()));
	}
	
	private static void buscaPeloNome(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		List<Produto> todosComNome = produtoDao.buscarPorNome(nome);
		todosComNome.forEach(ps -> System.out.println("Produto: " + ps.getDescricao()));
	}

	private static void buscaTudo(ProdutoDao produtoDao) {
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(ps -> System.out.println(ps.getDescricao()));
	}

	private static void inicializacaoEstoque() {
		Categoria vidros = new Categoria("VIDROS");
		Categoria carroceria = new Categoria("CARROCERIA");
		Categoria lanternas = new Categoria("LANTERNAS");
		
		Produto retrovisorCorollaE = new Produto("RETROVISOR COROLLA E", "RETROVISOR COR BRANCO LADO ESQUERDO TOYOTA COROLA 21/21", new BigDecimal("800"), vidros);
		Produto retrovisorCorollaD = new Produto("RETROVISOR COROLLA D", "RETROVISOR COR PRATA LADO DIREITO TOYOTA COROLA 21/21", new BigDecimal("810"), vidros);
		Produto parabrisaRanger = new Produto("PARA-BRISA RANGER", "VIDRO PARA-BRISA FORD RANGER 21/21", new BigDecimal("3000"), vidros);
		
		Produto portaGol = new Produto("PORTA GOL", "PORTA DO MOTORISTA GOL 1.0 19/19", new BigDecimal("4000"), carroceria);
		Produto paraChoqueGol = new Produto("PARA-CHOQUE GOL", "PARA-CHOQUE DIANTEIRO GOL VERMELHO 15/15", new BigDecimal("1200"), carroceria);
		Produto paraChoqueFiesta = new Produto("PARA-CHOQUE FIESTA", "PARA-CHOQUE TRASEIRO FIESTA PRATA 20/20", new BigDecimal("2500"), carroceria);
		
		Produto lanternaGolD = new Produto("FAROL GOL D", "FAROL DIREITO GOL 14/14", new BigDecimal("400"), lanternas);
		Produto lanternaGolE = new Produto("FAROL GOL E", "FAROL ESQUERDO GOL 14/14", new BigDecimal("400"), lanternas);
		Produto lanternaF250E = new Produto("FAROL F250 E", "FAROL ESQUERDO FORD F250 20/20", new BigDecimal("2000"), lanternas);
	
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();//inicia a transação
		
		categoriaDao.cadastrar(vidros);
		categoriaDao.cadastrar(carroceria);
		categoriaDao.cadastrar(lanternas);
		
		produtoDao.cadastrar(retrovisorCorollaE); //faz insert na tabela do banco
		produtoDao.cadastrar(retrovisorCorollaD);
		produtoDao.cadastrar(parabrisaRanger);
		
		produtoDao.cadastrar(portaGol);
		produtoDao.cadastrar(paraChoqueGol);
		produtoDao.cadastrar(paraChoqueFiesta);
		
		produtoDao.cadastrar(lanternaGolD);
		produtoDao.cadastrar(lanternaGolE);
		produtoDao.cadastrar(lanternaF250E);
		
		em.getTransaction().commit();//commit na transação no banco de dados.
		em.close();
		
		
	}
}