import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * tests the Users class
 * @author danny
 *
 */
public class UsersTest {

	ArrayList<Users> users;
	@Before
	public void setUp() throws Exception {
	    users = new ArrayList<Users>();
		users.add(new Users("first name", "second name", 1, "m", "occupation"));
		users.add(new Users("Danny", "O'Leary", 20, "m", "student"));
		users.add(new Users("Mary", "Doyle", 58, "f", "other"));
		users.add(new Users("David", "Walsh", 21, "m", "student"));
		users.add(new Users("Sean", "Doyle", 9, "m", "pilot"));
	}

	@After
	public void tearDown() throws Exception {
		users = null;
	}

	@Test
	public void testUsers() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the getUserId method
	 */
	@Test
	public void testGetUserId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the setUserId method
	 */
	@Test
	public void testSetUserId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the getFirstName method
	 */
	@Test
	public void testGetFirstName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the setFirstName method
	 */
	@Test
	public void testSetFirstName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the getLastName method
	 */
	@Test
	public void testGetLastName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the setLastName method
	 */
	@Test
	public void testSetLastName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the getAge method
	 */
	@Test
	public void testGetAge() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the setAge method
	 */
	@Test
	public void testSetAge() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the getGender method
	 */
	@Test
	public void testGetGender() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the setGender method
	 */
	@Test
	public void testSetGender() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the getOccupation method
	 */
	@Test
	public void testGetOccupation() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * tests the setOccupation method
	 */
	@Test
	public void testSetOccupation() {
		fail("Not yet implemented"); // TODO
	}

}
