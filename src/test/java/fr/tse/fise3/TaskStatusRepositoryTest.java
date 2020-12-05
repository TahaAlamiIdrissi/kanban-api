package fr.tse.fise3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.dao.TaskStatusRepository;
import fr.tse.fise3.domain.TaskStatus;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskStatusRepositoryTest {

	@Autowired
	private TaskStatusRepository taskStatusRepo;
	
	@Test
	public void testFindAllTaskStatus() {
		Collection<TaskStatus> listOfTaskStatus = taskStatusRepo.findAll();
		// we should have all the 4 states (DOING, TODO, DONE and TEST)
		assertEquals(4, listOfTaskStatus.size());
	}

}

