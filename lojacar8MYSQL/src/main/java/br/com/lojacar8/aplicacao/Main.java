package br.com.lojacar8.aplicacao;

import br.com.lojacar8.Categoria;
import br.com.lojacar8.Produto;
import br.com.lojacar8.dao.CategoriaDao;
import br.com.lojacar8.dao.ProdutoDao;

public class Main {

	public static void main(String[] args) {
		CategoriaDao cd = new CategoriaDao();
		ProdutoDao pd = new ProdutoDao();
		
		Categoria vidros = new Categoria("VIDROS");
		Produto retrovisorCorollaD = new Produto("RETROVISOR DIREITO COROLLA 21/21", "RETROVISOR DIREITO TOYOTA COROLLA 21/21 COR PRATA", 800.00, 1);
		
		cd.cadastro(vidros);
		pd.cadastro(retrovisorCorollaD);
	}

}
