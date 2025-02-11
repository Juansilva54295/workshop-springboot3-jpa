package com.projetospring.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.curso.entidade.User;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	
	
	@GetMapping
	public ResponseEntity<User> Todos(){
		User u = new User(1L,"maria" ,"maria@gmail.com", " 40028922","juanlindo");
		return ResponseEntity.ok().body(u);
	}

}
