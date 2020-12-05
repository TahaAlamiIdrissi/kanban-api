package fr.tse.fise3.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.fise3.domain.Task;
import fr.tse.fise3.services.TaskService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/task/")
@AllArgsConstructor
public class TaskController {
	
	private final TaskService taskService;

	@GetMapping("index")
	public String index() {
		return "hello from task ";
	}
	
	@GetMapping("tasks")
	public Collection<Task> getAllTasks(){
		return taskService.findAllTasks();
	}
}
