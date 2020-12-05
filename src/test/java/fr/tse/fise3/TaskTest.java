package fr.tse.fise3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.domain.ChangeLog;
import fr.tse.fise3.domain.Developer;
import fr.tse.fise3.domain.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskTest {

	@Test
	public void testAddDeveloperToTask() {
		Developer dev = new Developer();
		Task task = new Task();
		task.addDeveloper(dev);
		assertEquals(1, task.getDevelopers().size());
		assertEquals(1, dev.getTasks().size());
	}
	@Test
	public void testAddChangeLog() {
		ChangeLog changeLog = new ChangeLog();
		Task task = new Task();
		task.addChangeLog(changeLog);
		assertEquals(1, task.getChangeLogs().size());
		
	} 
}
