import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * tests the methods in the recommender class
 * @author danny
 *
 */
public class RecommenderTest {
	Recommender recommender;
	@Before
	public void setUp() throws Exception {
		recommender = new Recommender();
		recommender.addUsers("first name", "second name", 1, "m", "occupation");
		recommender.addUsers("Danny", "O'Leary", 20, "m", "student");
		recommender.addUsers("Mary", "Doyle", 58, "f", "other");
		recommender.addUsers("David", "Walsh", 21, "m", "student");
		recommender.addUsers("Sean", "Doyle", 9, "m", "pilot");
	}

	@After
	public void tearDown() throws Exception {
		recommender = null;
	}

	//@Test
	public void testRecommender() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the add users method in recommender
	 */
	@Test
	public void testAddUsers() {
		//Check if the results are right
		recommender.addUsers("random", "name", 25, "m", "other");
		assertTrue(recommender.getUser(5).getFirstName() == "random");
		assertTrue(recommender.getUser(0).getAge() == 1);
		assertTrue(recommender.getUser(1).getLastName() == "O'Leary");
		assertTrue(recommender.getUser(2).getGender() == "f");
		assertTrue(recommender.getUser(3).getOccupation() == "student");
		//Check the boundary conditions
		recommender.addUsers("reallylongfirstnameis", "reallylongsecondname", -5, "f", "reallylongoccupation");
		assertFalse(recommender.getUser(6).getFirstName() == "reallylongfirstnameis");
		assertTrue(recommender.getUser(6).getFirstName() == "reallylongfirs");
	}

}
