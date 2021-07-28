package main.java.br.com.lojacar8.facade;

import main.java.br.com.lojacar8.Categoria;
import main.java.br.com.lojacar8.dao.CategoriaDao;

public class CategoriaFacade {

	public void validaCategoria(String nome){
		try{
			CategoriaDao cd = new CategoriaDao();
			
			if(nome.toUpperCase().equalsIgnoreCase(cd.getCategoriaByName(nome))){
				System.out.println("Categoria " + nome.toUpperCase() + " já está cadastrada");
			}else{
				Categoria cat = new Categoria(nome.toUpperCase());
				cd.cadastro(cat);
				System.out.println("Categoria " + nome.toUpperCase() + " cadastrada com sucesso!");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
