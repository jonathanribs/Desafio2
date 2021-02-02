package br.com.flowtalents.desafio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flowtalents.desafio2.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
