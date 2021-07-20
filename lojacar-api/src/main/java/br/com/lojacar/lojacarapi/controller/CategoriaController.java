package br.com.lojacar.lojacarapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojacar.lojacarapi.model.Categoria;
import br.com.lojacar.lojacarapi.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> getCategorias() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria adicionar(@RequestBody Categoria categoria){
		return categoriaRepository.save(categoria);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria delCategorias(@PathVariable Long id){
		Categoria categoria = new Categoria();
		categoria = categoriaRepository.findById(id).orElse(null);
		if (categoria != null){
			categoriaRepository.delete(categoria);
		}
		return categoria;	
	}
}
