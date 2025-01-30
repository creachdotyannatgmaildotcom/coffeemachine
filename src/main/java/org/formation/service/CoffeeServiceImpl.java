package org.formation.service;

import java.util.List;
import java.util.Optional;

import org.formation.model.Coffee;
import org.formation.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CoffeeServiceImpl implements CoffeeService {

	private CoffeeRepository repository;

	public CoffeeServiceImpl(CoffeeRepository repository) {
		this.repository = repository;
	}

	//@PostConstruct
	public void initDb() {
		repository.saveAll(List.of(new Coffee("from database"), new Coffee("Tres puntas"), new Coffee("Robusta")));
	}

	@Override
	public List<Coffee> getAll() {
		return repository.findAll();
	}

	@Override
	public Coffee save(Coffee coffee) {
		return repository.save(coffee);
	}

	@Override
	public Optional<Coffee> getById(Long id) {
		return repository.findById(id);
	}

}
