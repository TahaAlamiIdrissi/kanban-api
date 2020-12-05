package fr.tse.fise3.utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.tse.fise3.dao.DeveloperRepository;
import fr.tse.fise3.dao.TaskRepository;
import fr.tse.fise3.dao.TaskStatusRepository;
import fr.tse.fise3.dao.TaskTypeRepository;
import fr.tse.fise3.domain.Developer;
import fr.tse.fise3.domain.Task;
import fr.tse.fise3.domain.TaskStatus;
import fr.tse.fise3.domain.TaskType;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@Component
public class LoadDatabase {

	@Bean
	// @Profile("test")
	CommandLineRunner initTestDatabase(TaskStatusRepository taskStatusRepository,
			DeveloperRepository developerRepository, TaskTypeRepository taskTypeRepository,
			TaskRepository taskRepository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {

				initTaskStatus(taskStatusRepository);
				initTaskTypes(taskTypeRepository);
				// we are seeding one developer, "taha" for unit testing
				Developer dev = initDevelopers(developerRepository);
				Task task1 = initTasks(taskRepository, dev, taskStatusRepository, taskTypeRepository,"Fix npm vulnerability");
				Task task2 = initTasks(taskRepository, dev, taskStatusRepository, taskTypeRepository,"Audit server");
			}
		};
	}

	private void initTaskStatus(TaskStatusRepository taskStatusRepository) {

		// Seeding TaskStatus states and data to the DB and loging some info
		TaskStatus todoTask = new TaskStatus(Constants.TASK_STATUS_ID_TODO, Constants.TASK_STATUS_LABEL_TODO);
		taskStatusRepository.save(todoTask);
		log.info("New item saved to DB " + todoTask);

		TaskStatus doingTask = new TaskStatus(Constants.TASK_STATUS_ID_DOING, Constants.TASK_STATUS_LABEL_DOING);
		taskStatusRepository.save(doingTask);
		log.info("New item saved to DB " + doingTask);

		TaskStatus testTask = new TaskStatus(Constants.TASK_STATUS_ID_TEST, Constants.TASK_STATUS_LABEL_TEST);
		taskStatusRepository.save(testTask);
		log.info("New item saved to DB " + testTask);

		TaskStatus doneTask = new TaskStatus(Constants.TASK_STATUS_ID_DONE, Constants.TASK_STATUS_LABEL_DONE);
		taskStatusRepository.save(doneTask);
		log.info("New item saved to DB " + doneTask);

	}

	private void initTaskTypes(TaskTypeRepository taskTypeRepository) {
		// Seeding TaskStatus states and data to the DB and loging some info
		TaskType bugTask = new TaskType(Constants.TASK_TYPES_ID_BUG, Constants.TASK_TYPES_LABEL_BUG);
		taskTypeRepository.save(bugTask);
		log.info("New item saved to DB" + bugTask);

		TaskType featureTask = new TaskType(Constants.TASK_TYPES_ID_FEATURE, Constants.TASK_TYPES_LABEL_FEATURE);
		taskTypeRepository.save(featureTask);
		log.info("New item saved to DB" + featureTask);
	}

	private Developer initDevelopers(DeveloperRepository developerRepository) {
		// Seeding Developers data to the DB

		Developer taha = new Developer();
		taha.setFirstname("taha");
		taha.setEmail("taha.alami@telecom-st-etienne.fr");
		taha.setLastname("alami");
		taha.setPassword("password");
		taha.setStartContract(LocalDate.of(2019, Month.SEPTEMBER, 28));
		Developer dev = developerRepository.save(taha);
		log.info("new developer saved to DB " + taha);
		return dev;
	}

	private Task initTasks(TaskRepository taskRepository, Developer dev, TaskStatusRepository taskStatusRepository,
			TaskTypeRepository taskTypeRepository,String title) {
		Task taskOne = new Task();
		taskOne.addDeveloper(dev);
		taskOne.setTitle(title);
		taskOne.setCreated(LocalDate.now());
		taskOne.setNbHoursForecast(0);
		taskOne.setNbHoursReal(0);
		taskOne.setStatus(taskStatusRepository.findById(Constants.TASK_STATUS_ID_TODO).orElse(null));
		taskOne.setType(taskTypeRepository.findById(Constants.TASK_TYPES_ID_BUG).orElse(null));
		Task task = taskRepository.save(taskOne);
		log.info("new Task saved to DB" + taskOne);
		return task;
	}
}
