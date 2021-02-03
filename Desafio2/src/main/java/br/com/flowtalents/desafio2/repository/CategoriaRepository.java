package br.com.flowtalents.desafio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flowtalents.desafio2.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
