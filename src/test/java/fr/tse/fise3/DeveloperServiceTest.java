package fr.tse.fise3;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.domain.Developer;
import fr.tse.fise3.services.DeveloperService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeveloperServiceTest {

	@Autowired
	private DeveloperService developerService;
	
	@Test
	public void testGetAllDevelopers() {
		// testing the findAllDevelopers from the service layer
		Collection<Developer> developers = this.developerService.findAllDevelopers();
		assertEquals(1, developers.size());
	}

}
