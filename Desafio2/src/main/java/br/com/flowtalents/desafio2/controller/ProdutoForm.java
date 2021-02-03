package br.com.flowtalents.desafio2.controller;


import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.flowtalents.desafio2.model.Categoria;
import br.com.flowtalents.desafio2.model.Produto;
import br.com.flowtalents.desafio2.repository.CategoriaRepository;

public class ProdutoForm {

	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	@NotNull @Positive
	private Long idCategoria;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public Produto converter(CategoriaRepository categoriaRepository) {
		
		Categoria categoria = new Categoria();
		Optional<Categoria> c = categoriaRepository.findById(this.idCategoria);
		if (c.isEmpty()) {
			return null;
		}
		categoria = c.get();
		return new Produto(this.titulo, this.descricao, categoria);
	}
	
}
