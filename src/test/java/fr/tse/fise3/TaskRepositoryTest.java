package fr.tse.fise3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.dao.TaskRepository;
import fr.tse.fise3.domain.Task;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskRepositoryTest {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Test
	public void testGetTask() {
		Optional<Task> task = taskRepository.findById(2L);
		
		assertEquals("Fix npm vulnerability", task.get().getTitle());
	}

}
