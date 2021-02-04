package br.com.flowtalents.desafio2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	@ManyToOne @JoinColumn(nullable = false)
	private Categoria categoria;
	private Long pontuacao = 0L;
	private String urlImagem;
	

	@Deprecated 
	public Produto() {//só é usado pelo Spring Data
	}
	
	public Produto(String titulo, String descricao, Categoria categoria) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Long getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(Long pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	
}
