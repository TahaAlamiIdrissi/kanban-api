package fr.tse.fise3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.dao.TaskRepository;
import fr.tse.fise3.dao.TaskStatusRepository;
import fr.tse.fise3.domain.Task;
import fr.tse.fise3.domain.TaskStatus;
import fr.tse.fise3.domain.TaskType;
import fr.tse.fise3.services.TaskService;
import fr.tse.fise3.utils.Constants;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceTest {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
/*
 * @Notice: Before running this test make sure we have only "2" Tasks in the DB 
 *  The first test can be used to be sure !
 *  
 */
	
	@Test
	public void testGetAllTasksFromTaskService() {
		Collection<Task> tasks = taskService.findAllTasks();
		assertEquals(2, tasks.size());
	}
	
	
	@Test
	public void testGetTaskByIdFromTaskService() {
		Task task = taskService.findTask(2L);
		assertEquals("Fix npm vulnerability", task.getTitle());
	}
	
	@Test
	public void testGetTaskTypeFromTaskService() {
		TaskType taskType = taskService.findTaskType(Constants.TASK_TYPES_ID_BUG);
		assertEquals("BUG", taskType.getLabel());
	}
	
	@Test
	public void testGetTaskStatusFromTaskService() {
		TaskStatus taskStatus = taskService.findTaskStatus(Constants.TASK_STATUS_ID_DOING);
		assertEquals("DOING", taskStatus.getLabel());
	}
	
	@Test
	public void testGetAllTaskStatusFromTaskService() {
		Collection<TaskStatus> listOfTaskStatusFromTaskService = taskService.findAllTaskStatus();
		assertEquals(4, listOfTaskStatusFromTaskService.size());
	}
	
	@Test
	public void testGetAllTaskTypesFromTaskService() {
		Collection<TaskType> listOfTaskTypesFromTaskService = taskService.findAllTaskTypes();
		assertEquals(2, listOfTaskTypesFromTaskService.size());
	}
	
	@Test 
	public void testCreateTask() {
		Task task = new Task();
		task.setTitle("Test Task");
		Task test = taskService.createTask(task);
		assertEquals("Test Task", test.getTitle());
	}
	
//	@Test
//	public void testDeleteTask() {
//		Task task = taskService.findTask(3L);
//		Task deletedTask = taskService.deleteTask(task);
//		assertEquals(1, taskService.findAllTasks().size());
//	}
	@Test
	public void testGetFollowingTask() {
		TaskStatus currentTaskStatus = this.taskStatusRepository.findById(Constants.TASK_STATUS_ID_TODO).get();
		TaskStatus actual = this.taskService.getFollowingTask(currentTaskStatus);
		TaskStatus expected = this.taskStatusRepository.findById(Constants.TASK_STATUS_ID_DOING).get();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetPreviousTask() {
		TaskStatus currentTaskStatus = this.taskStatusRepository.findById(Constants.TASK_STATUS_ID_DONE).get();
		TaskStatus actual = this.taskService.getPreviousTask(currentTaskStatus);
		TaskStatus expected = this.taskStatusRepository.findById(Constants.TASK_STATUS_ID_TEST).get();
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testUpdateTaskStatus() {
		
	}
}
