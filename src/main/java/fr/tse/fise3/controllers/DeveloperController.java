package fr.tse.fise3.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.fise3.domain.Developer;
import fr.tse.fise3.services.DeveloperService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/developer/")
@AllArgsConstructor
public class DeveloperController {
	
	private final DeveloperService developerService;

	@GetMapping("index")
	public String index() {
		return "Hello from dev";
	}
	
	
	@GetMapping("developers")
	public List<Developer> getAllDevelopers(){
		return developerService.findAllDevelopers();
	}
}
