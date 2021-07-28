package main.java.br.com.lojacar8.facade;

import main.java.br.com.lojacar8.Produto;
import main.java.br.com.lojacar8.dao.CategoriaDao;
import main.java.br.com.lojacar8.dao.ProdutoDao;

public class ProdutoFacade {

	public void validaProduto(String nome, String descricao, double preco, int categoria){
		try{
			CategoriaDao cd = new CategoriaDao();
			ProdutoDao pd = new ProdutoDao();
			
			if(cd.getCategoriaById(categoria)==null){
				System.out.println("Insira uma categoria válida!");
			}else {
				if(nome.toUpperCase().equalsIgnoreCase(pd.getProdutoByName(nome))){
					System.out.println("Produto " + nome.toUpperCase() + " já está cadastrado");
				}else{
					Produto prod = new Produto(nome.toUpperCase(), descricao.toUpperCase(), preco, categoria);
					pd.cadastro(prod);
					System.out.println("Produto " + nome.toUpperCase() + " cadastrado com sucesso!");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
