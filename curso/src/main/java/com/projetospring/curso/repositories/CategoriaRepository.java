package com.projetospring.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.curso.entidade.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	
}
