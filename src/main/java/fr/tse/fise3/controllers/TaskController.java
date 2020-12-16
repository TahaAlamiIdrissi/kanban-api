package fr.tse.fise3.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.fise3.dao.TaskTypeRepository;
import fr.tse.fise3.domain.Task;
import fr.tse.fise3.domain.TaskStatus;
import fr.tse.fise3.domain.TaskType;
import fr.tse.fise3.services.TaskService;
import fr.tse.fise3.utils.Constants;
import fr.tse.fise3.utils.TaskMoveAction;
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
	public Collection<Task> getAllTasks() {
		return taskService.findAllTasks();
	}

	@GetMapping("task-types")
	public Collection<TaskType> getAllTaskTypes() {
		return taskService.findAllTaskTypes();
	}

	@GetMapping("task-status")
	public Collection<TaskStatus> getAllTaskStatus() {
		return taskService.findAllTaskStatus();
	}

	@PostMapping("tasks")
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	@PatchMapping("tasks/{id}")
	public Task moveTask(@RequestBody String way, @PathVariable Long id) throws Exception {
		Task task = taskService.findTask(id);
		if (way.equals(Constants.MOVE_LEFT)) {
			task = taskService.moveLeftTask(task);
		} else if (way.equals(Constants.MOVE_RIGHT)) {
			task = taskService.moveRightTask(task);
		} else
			throw new Exception("move action not found please enter LEFT or RIGHT");
		return task;
	}

}
