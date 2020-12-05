package fr.tse.fise3;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.dao.DeveloperRepository;
import fr.tse.fise3.domain.Developer;
import fr.tse.fise3.domain.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeveloperRepositoryTest {
	
	@Autowired
	private DeveloperRepository developerRepository;

	@Test
	public void testAddDevelopers() {
		// testing the add method of the JpaRepository 
		assertEquals("taha", this.developerRepository.findById(1L).get().getFirstname());
	}
	
	@Test
	public void testFindAllDevelopers() {
		Collection<Developer> developers = this.developerRepository.findAll();
		assertEquals(1, developers.size());
	}

}
