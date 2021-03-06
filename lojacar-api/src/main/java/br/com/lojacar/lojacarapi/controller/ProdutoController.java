package br.com.lojacar.lojacarapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojacar.lojacarapi.model.Produto;
import br.com.lojacar.lojacarapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> getProduto() {
		return produtoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
//	@DeleteMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Produto remover(@RequestBody Produto produto){
//		return produtoRepository.delete();
//	}
}
