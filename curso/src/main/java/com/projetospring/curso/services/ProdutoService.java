package com.projetospring.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetospring.curso.entidade.Produto;
import com.projetospring.curso.repositories.ProdutoRepository;


@Service
public class ProdutoService  {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj =repository.findById(id);
		return obj.get();
	}
	

}
