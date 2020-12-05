package fr.tse.fise3.services;

import java.util.List;
import java.util.Optional;

import fr.tse.fise3.domain.Developer;

public interface DeveloperService {
	List<Developer> findAllDevelopers();
	Optional<Developer> findDeveloperById(Long id);
}
