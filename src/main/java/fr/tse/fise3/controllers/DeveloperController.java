package fr.tse.fise3.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.fise3.domain.Developer;
import fr.tse.fise3.services.DeveloperService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/developer/")
@AllArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600,
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
	@GetMapping("developers/{id}")
	public Developer getDeveloperById(@PathVariable Long id){
		return developerService.findDeveloperById(id).get();
	}
}
