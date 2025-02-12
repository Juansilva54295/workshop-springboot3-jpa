package com.projetospring.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.curso.entidade.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	
}
