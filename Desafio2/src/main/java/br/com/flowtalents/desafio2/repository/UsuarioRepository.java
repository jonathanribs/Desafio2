package br.com.flowtalents.desafio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flowtalents.desafio2.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByNome(String nome);

}
