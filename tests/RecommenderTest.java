import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RecommenderTest {
	Main main;

	@Before
	public void setUp() throws Exception {
		main = new Main();
	    main.createUser("first name", "second name", 1, "m", "occupation");
		main.createUser("Danny", "O'Leary", 20, "m", "student");
		main.createUser("Mary", "Doyle", 58, "f", "other");
		main.createUser("David", "Walsh", 21, "m", "student");
		main.createUser("Sean", "Doyle", 9, "m", "pilot");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoad() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testStore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddUsers() {
		main.createUser("random", "name", 25, "m", "other");
	}

	@Test
	public void testRemoveUser() {
		main.deleteUser(1);
	}

	@Test
	public void testAddRating() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetUsersRatedMovies() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetAverageRating() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetUser() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddMovie() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetMovieDetails() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTopTen() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetUserRecommendations() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testReadInMovie() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testClone() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testWait() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented"); // TODO
	}

}
