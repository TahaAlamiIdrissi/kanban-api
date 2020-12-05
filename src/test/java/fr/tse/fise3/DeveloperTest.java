package fr.tse.fise3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.dao.DeveloperRepository;
import fr.tse.fise3.dao.TaskRepository;
import fr.tse.fise3.domain.Developer;
import fr.tse.fise3.domain.Task;
import fr.tse.fise3.utils.Constants;



@SpringBootTest
@RunWith(SpringRunner.class)
public class DeveloperTest {
	
	@Autowired
	private DeveloperRepository developerRepository;
	@Autowired
	private TaskRepository taskRepository;

	@Test
	public void testDeveloperSeedInDB() {
		Optional<Developer>dev = this.developerRepository.findById(1L);
		assertEquals("taha", dev.get().getFirstname());
	}
	
	

}
