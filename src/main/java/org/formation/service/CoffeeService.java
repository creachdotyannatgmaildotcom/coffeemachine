package org.formation.service;

import java.util.List;
import java.util.Optional;

import org.formation.model.Coffee;

public interface CoffeeService {
	
	List<Coffee> getAll();
	Coffee save(Coffee coffee);
	Optional<Coffee> getById(Long id);

}
