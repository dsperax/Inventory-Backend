package br.com.lojacar8.aplicacao;

import br.com.lojacar8.dao.CategoriaDao;
import br.com.lojacar8.dao.ProdutoDao;

public class Main {

	public static void main(String[] args) {
		CategoriaDao cd = new CategoriaDao();
		ProdutoDao pd = new ProdutoDao();
		
		//Categoria vidros = new Categoria("VIDROS");
		//Categoria carroceria = new Categoria("CARROCERIA");
		//Categoria testeUp = new Categoria("teste Update Errado");
		
		//Produto retrovisorCorollaD = new Produto("RETROVISOR DIREITO COROLLA 21/21", "RETROVISOR DIREITO TOYOTA COROLLA 21/21 COR PRATA", 800.00, 1);
		//Produto paraChoqueRanger = new Produto("PARA CHOQUE RANGER DIANTEIRO BRANCO", "PARA CHOQUE DIANTEIRO RANGER 20/20 BRANCO", 3800.00, 2);
		//Produto testeProd = new Produto("Teste Produto errado", "TESTE", 80130.00, 3);
		
		
		//Produto testeProd1 = new Produto("Teste Produto CATEGORIA ERRADA", "TESTE", 80.00, 4); //-> FAZER TRATAMENTO PARA CATEGORIA INEXISTENTE
		
		//-------------------------CADASTRO DE CATEGORIAS-----------------------------
		//cd.cadastro(vidros);
		//cd.cadastro(carroceria);
		//cd.cadastro(testeUp);
		
		//-------------------------CADASTRO DE PRODUTOS-------------------------------
		//pd.cadastro(retrovisorCorollaD);
		//pd.cadastro(paraChoqueRanger);
		//pd.cadastro(testeProd);
		//pd.cadastro(testeProd1); //-> FAZER TRATAMENTO PARA CATEGORIA INEXISTENTE
		
		//-------------------------CONSULTA DE CATEGORIAS-----------------------------
		System.out.println(cd.getCategorias());
		System.out.println();
		
		//--------------------------CONSULTA DE PRODUTOS------------------------------
		System.out.println(pd.getProdutos());
		System.out.println();
		
		
		// -------------------------UPDATE DE CATEGORIAS------------------------------
		//Categoria testeUpCorreto = new Categoria("UPDATE COM SUCESSO!");
		//testeUpCorreto.setID_CATEGORIA(3);
		//cd.update(testeUpCorreto);
		
		//--------------------------UPDATE DE PRODUTOS--------------------------------
		//Produto testeProdCorreto = new Produto("UPDATE PRODUTO CORRETO", "CORRETO!", 20.00, 1);
		//testeProdCorreto.setID_PRODUTO(3);
		//pd.update(testeProdCorreto);
		
		// -------------------------DELETE DE CATEGORIAS------------------------------
//		cd.deleteByID(3);
//		System.out.println(cd.getCategorias());
//		System.out.println();
		
		// -------------------------DELETE PRODUTOS-----------------------------------
//		pd.deleteByID(3);
//		System.out.println(pd.getProdutos());
//		System.out.println();
		
	}

}
