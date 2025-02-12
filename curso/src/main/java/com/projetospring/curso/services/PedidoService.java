package com.projetospring.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetospring.curso.entidade.Pedido;
import com.projetospring.curso.repositories.PedidoRepository;
import com.projetospring.curso.repositories.UserRepository;


@Service
public class PedidoService  {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj =repository.findById(id);
		return obj.get();
	}
	

}
