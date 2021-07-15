package br.com.lojacar.lojacarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lojacar.lojacarapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
