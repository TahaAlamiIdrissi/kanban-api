package fr.tse.fise3;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.dao.TaskTypeRepository;
import fr.tse.fise3.domain.TaskType;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskTypeRepositoryTest {
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;

	@Test
	public void test() {
		Collection<TaskType> listOfTaskType = taskTypeRepository.findAll();
		
		// we should have both states (BUG,FEATURE)
		assertEquals(2, listOfTaskType.size());
	}

}
