package br.com.flowtalents.desafio2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flowtalents.desafio2.model.Produto;
import br.com.flowtalents.desafio2.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

	@GetMapping("/products")
	public List<Produto> listaProdutos(){
		List<Produto> lista = new ArrayList<>();
		lista = produtoRepository.findAll();
		return lista;
	}
	

	
}
