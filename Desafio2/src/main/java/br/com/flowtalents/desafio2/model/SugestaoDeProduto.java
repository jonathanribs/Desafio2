package br.com.flowtalents.desafio2.model;

import javax.validation.constraints.NotBlank;

public class SugestaoDeProduto {

	@NotBlank
	private String nome;
	@NotBlank
	private String nomeDoMercado;
	@NotBlank
	private String texto;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeDoMercado() {
		return nomeDoMercado;
	}
	public void setNomeDoMercado(String nomeDoMercado) {
		this.nomeDoMercado = nomeDoMercado;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
