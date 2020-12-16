package fr.tse.fise3.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.tse.fise3.domain.Task;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TaskControllerTest extends ControllerTest {

	@Test
	public void testGelAllTasks() throws Exception {
		mvc.perform(get("/api/task/tasks").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title", is("Fix npm vulnerability")))
				.andExpect(jsonPath("$[1].title", is("Audit server")));
	}
	
	@Test
	public void testGelAllTaskTypes() throws Exception {
		mvc.perform(get("/api/task/task-types").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].label", is("BUG")))
		.andExpect(jsonPath("$[1].label", is("FEATURE")));
	}
	@Test
	public void testGelAllTaskStatus() throws Exception {
		mvc.perform(get("/api/task/task-status").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].label", is("TODO")))
		.andExpect(jsonPath("$[1].label", is("DOING")))
		.andExpect(jsonPath("$[2].label", is("TEST")))
		.andExpect(jsonPath("$[3].label", is("DONE")));
	}
	@Test
	public void testCreateTask() throws Exception {
		Task task = new Task();
		task.setTitle("Testing server 2");
		task.setNbHoursForecast(6);
		task.setNbHoursReal(4);

		mvc.perform(post("/api/task/tasks").contentType(MediaType.APPLICATION_JSON).content(asJsonString(task))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	@Test
	public void testMoveTask() throws Exception {

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
