package main.java.br.com.lojacar8.facade;

import main.java.br.com.lojacar8.Categoria;
import main.java.br.com.lojacar8.dao.CategoriaDao;

public class CategoriaFacade {

	public void validaCategoria(String nome){
		try{
			CategoriaDao cd = new CategoriaDao();
			
			if(nome.toUpperCase().equalsIgnoreCase(cd.getCategoriaByName(nome))){
				System.out.println("Categoria " + nome.toUpperCase() + " já está cadastrada");
				
			}else if(nome.length()<1){
				System.out.println("A categoria precisa possuir um nome!");
			}else{
				Categoria cat = new Categoria(nome.toUpperCase());
				cd.cadastro(cat);
				System.out.println("Categoria " + nome.toUpperCase() + " cadastrada com sucesso!");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deletaCategoria(int id){
		
		try{
			CategoriaDao cd = new CategoriaDao();
			
			if(cd.getCategoriaById(id) == null){
				System.out.println("Verifique o ID digitado!");
			}else{
				String deletada = cd.getCategoriaById(id);
				cd.deleteByID(id);
				System.out.println("Categoria " + deletada + " excluida com sucesso!");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
