package main.java.br.com.lojacar8.aplicacao;

import main.java.br.com.lojacar8.Categoria;
import main.java.br.com.lojacar8.Produto;
import main.java.br.com.lojacar8.dao.CategoriaDao;
import main.java.br.com.lojacar8.dao.ProdutoDao;
import main.java.br.com.lojacar8.facade.CategoriaFacade;
import main.java.br.com.lojacar8.facade.ProdutoFacade;

public class Main {

	public static void main(String[] args) {
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
	
	public static void updCategoria(String nome, int id_categoria){
		CategoriaDao cd = new CategoriaDao();
		Categoria UpCorreto = new Categoria(nome.toUpperCase());
		UpCorreto.setID_CATEGORIA(id_categoria);
		cd.update(UpCorreto);
	}
	
	public static void delCategoria(int id_categoria){
		CategoriaDao cd = new CategoriaDao();
		String cat = cd.getCategoriaById(id_categoria);
		cd.deleteByID(id_categoria);
		System.out.println("Categoria " + cat + " excluida com sucesso!");
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
	}
	
	public static void delProduto(int id_produto){
		ProdutoDao pd = new ProdutoDao();
		String prod = pd.getProdutoById(id_produto);
		pd.deleteByID(id_produto);
		System.out.println("Produto " + prod + " excluida com sucesso!");
	}
}





















