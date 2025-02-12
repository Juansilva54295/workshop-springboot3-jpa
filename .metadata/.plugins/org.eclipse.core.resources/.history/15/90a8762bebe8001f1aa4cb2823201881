package com.projetospring.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetospring.curso.entidade.Categoria;
import com.projetospring.curso.entidade.Pedido;
import com.projetospring.curso.entidade.User;
import com.projetospring.curso.entidade.enums.StatusPedido;
import com.projetospring.curso.repositories.CategoriaRepository;
import com.projetospring.curso.repositories.PedidoRepository;
import com.projetospring.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class Testconfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
      
		Pedido o1 = new Pedido (null, Instant.parse("2019-06-20T19:53:07Z"),StatusPedido.PAID, u1);
		Pedido o2 = new Pedido (null, Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.DELIVERED, u2);
		Pedido o3 = new Pedido (null, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.WAITING_PAYMENT, u1); 
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers"); 

		
		userRepository.saveAll(Arrays.asList(u1,u2));
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
	    categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}

}
