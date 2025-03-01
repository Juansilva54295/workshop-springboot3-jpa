package com.projetospring.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetospring.curso.entidade.User;
import com.projetospring.curso.repositories.UserRepository;
import com.projetospring.curso.services.exceptions.DatabaseException;
import com.projetospring.curso.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


@Service
public class UserService  {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj =repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert (User obj) {
		return repository.save(obj);
	}
	
	public void deletar (Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User atualizar(Long id, User obj) {
		try {
		User entidade = repository.getReferenceById(id);
		updadeData(entidade,obj);
		return repository.save(entidade);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updadeData(User entidade, User obj) {	
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setNumero(obj.getNumero());
	}

}
