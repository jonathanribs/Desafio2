package br.com.flowtalents.desafio2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.flowtalents.desafio2.model.Categoria;
import br.com.flowtalents.desafio2.model.Produto;
import br.com.flowtalents.desafio2.model.SugestaoDeProduto;
import br.com.flowtalents.desafio2.model.Usuario;
import br.com.flowtalents.desafio2.repository.CategoriaRepository;
import br.com.flowtalents.desafio2.repository.ProdutoRepository;
import br.com.flowtalents.desafio2.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/products")
	public List<Produto> listaProdutos(){
		List<Produto> lista = new ArrayList<>();
		lista = produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "id")); //outra forma seria findByOrderByIdAsc();
		return lista;
	}
	
	@PutMapping("/products")
	@Transactional
	public ResponseEntity<List<Produto>> incrementaPontuacao(@RequestParam String id){
		
		Optional<Produto> p = produtoRepository.findById(Long.parseLong(id));
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Produto produto = p.get();

		Long pontuacao = produto.getPontuacao();
		produto.setPontuacao(pontuacao + 1L);
		
		List<Produto> lista = new ArrayList<>();
		lista = produtoRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/form")
	@Transactional
	public void novaSugestao(@RequestBody @Valid SugestaoDeProduto sugestao) {
		
	}
	
	@PostMapping("/security")
	public ResponseEntity<?> autenticar(@RequestBody @Valid Usuario usuarioInformado){
		
		Usuario usuario = usuarioRepository.findByNome(usuarioInformado.getNome());
		
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}	
		
		if (usuarioInformado.getSenha().equals(usuario.getSenha())) {
			return ResponseEntity.ok("Usuario Logado");
		} else {
			return ResponseEntity.badRequest().build(); //senha inválida
		}
		
	}
	
	
	
	@PostMapping("/newCategory")
	@Transactional
	public ResponseEntity<?> novaCategoria(@RequestParam String nomeCategoria) {
		
		Categoria categoria = new Categoria();
		categoria.setNome(nomeCategoria);
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/newProduct")
	@Transactional
	public ResponseEntity<?> novoProduto(@RequestBody @Valid ProdutoForm novoProduto) {
		
		Produto produto = novoProduto.converter(categoriaRepository);
		
		if (produto != null) {
			produtoRepository.save(produto);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().body("É necessário passar um id de categoria válido!");
	}
	
}
