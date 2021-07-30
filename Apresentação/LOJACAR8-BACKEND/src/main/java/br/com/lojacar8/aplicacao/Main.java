package main.java.br.com.lojacar8.aplicacao;

import main.java.br.com.lojacar8.Categoria;
import main.java.br.com.lojacar8.Produto;
import main.java.br.com.lojacar8.dao.CategoriaDao;
import main.java.br.com.lojacar8.dao.ProdutoDao;
import main.java.br.com.lojacar8.facade.CategoriaFacade;
import main.java.br.com.lojacar8.facade.ProdutoFacade;

public class Main {

	public static void main(String[] args) {
		
//		addCategoria("Vidro");
//		addCategoria("carroceria");
//		addCategoria("LANTERNA");
		
//		addCategoria("LANTERNA"); //repetida
			
//		updCategoria("Vidros", 1);
		
//	    addCategoria("parafusos");
//		delCategoria(4);
		
		//---------------------------------------------------------------------------------------------------------------
		
//		addProduto("retrovisor", "retrovisor toyota corolla lado direito cor branca", 1400.00, 1);
//		//addProduto("retrovisor", "retrovisor toyota corolla lado direito cor branca", 1400.00, 1);
//		delProduto(1);
		
		//---------------------------------------------------------------------------------------------------------------
		
//		addProduto("retrovisor corolla d", "retrovisor toyota corolla lado direito cor branca 19/19", 1400.00, 1);
//		addProduto("retrovisor corsa e", "retrovisor chevrolet corsa prata 10/10 ", 200.00, 1);
//		addProduto("para brisa ranger", "para brisa ford ranger 14/14", 3400.00, 1);
//		
//		addProduto("porta direita gol 14/14", "porta lado direito dianteira gol 14/14 cor branca", 1700.00, 2);
//		addProduto("para choque dianteiro fusca", "para choque dianteiro de fusca (conferir modelo)", 600.00, 1); //update nesse
		
		
		//---------------------------------------------------------------------------------------------------------------

//		updProduto("para choque fusca 70 a 80", "para choque dianteiro fusca ano 70 a 80", 400, 2,6);
		
		//---------------------------------------------------------------------------------------------------------------
		
//		addProduto("farol dianteiro astra", "farol dianteiro esquerdo astra 08/08", 320.00, 9); //categoria invalida (correto seria 3)
		
		//---------------------------------------------------------------------------------------------------------------
		
		
//		delCategoria(1); //deletar categoria que tem algo atrelado
		
		getCategorias();
		getProdutos();
	}
	
	//-----------------------Métodos CRUD Categorias----------------------------------
	
	public static void addCategoria(String nome){
		CategoriaFacade cf = new CategoriaFacade();
		cf.validaCategoria(nome.toUpperCase());		
	}
	
	public static void getCategorias(){
		CategoriaDao cd = new CategoriaDao();
		System.out.println(cd.getCategorias());	
	}
	
	public static void updCategoria(String novo_nome_categoria, int id_categoria){
		CategoriaDao cd = new CategoriaDao();
		Categoria UpCorreto = new Categoria(novo_nome_categoria.toUpperCase());
		UpCorreto.setID_CATEGORIA(id_categoria);
		cd.update(UpCorreto);
		System.out.println("Categoria atualizada com sucesso!");
	}
	
	public static void delCategoria(int id_categoria){
		CategoriaFacade cf = new CategoriaFacade();
		cf.deletaCategoria(id_categoria);
	}
	
	//-----------------------Métodos CRUD produtos-----------------------------------
	
	public static void addProduto(String nome, String descricao, double preco, int id_categoria){
		ProdutoFacade pf = new ProdutoFacade();
		pf.validaProduto(nome.toUpperCase(), descricao.toUpperCase(), preco, id_categoria);
	}
	
	public static void getProdutos(){
		ProdutoDao pd = new ProdutoDao();
		System.out.println(pd.getProdutos());
	}
	
	public static void updProduto(String nome, String descricao, double preco, int id_categoria, int id_produto_para_substituir){
		ProdutoDao pd = new ProdutoDao();
		Produto ProdCorreto = new Produto(nome.toUpperCase(), descricao.toUpperCase(), preco, id_categoria);
		ProdCorreto.setID_PRODUTO(id_produto_para_substituir);
		pd.update(ProdCorreto);
		System.out.println("Produto atualizado com sucesso!");
	}
	
	public static void delProduto(int id_produto){
		ProdutoDao pd = new ProdutoDao();
		String prod = pd.getProdutoById(id_produto);
		pd.deleteByID(id_produto);
		System.out.println("Produto " + prod + " excluida com sucesso!");
	}
}





















