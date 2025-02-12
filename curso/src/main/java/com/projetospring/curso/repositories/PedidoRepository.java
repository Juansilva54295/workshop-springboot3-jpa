package com.projetospring.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.curso.entidade.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	
}
