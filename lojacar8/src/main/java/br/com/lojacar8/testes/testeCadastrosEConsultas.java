package br.com.lojacar8.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.lojacar8.Categoria;
import br.com.lojacar8.Produto;
import br.com.lojacar8.dao.CategoriaDao;
import br.com.lojacar8.dao.ProdutoDao;
import br.com.lojacar8.util.JPAUtil;

public class testeCadastrosEConsultas {
	public static void main(String[] args) {
		inicializacaoEstoque();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
//		Produto p = produtoDao.buscarPorId(1l);
//		System.out.println(p.getPreco());
//		Produto p2 = produtoDao.buscarPorId(2l);
//		System.out.println(p2.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(ps -> System.out.println(ps.getDescricao()));
		
		List<Produto> todosComNome = produtoDao.buscarPorNome("FAROL GOL D");
		todosComNome.forEach(ps -> System.out.println("Produto: " + ps.getDescricao()));
	
		List<Produto> todosComNomeCategoria = produtoDao.buscarPorCategoria("VIDROS");
		todosComNomeCategoria.forEach(ps -> System.out.println(ps.getDescricao()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("RETROVISOR COROLLA D");
		System.out.println("Preço do produto: " + precoDoProduto);
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
