package com.projetospring.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.curso.entidade.PedidoItem;


public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{

	
}
