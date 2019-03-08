package models;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void testGetSetUsername() {
		User user = new User("Test");
		String newUsername = "Test 2";
		
		user.setName(newUsername);
		
		Assert.assertEquals("The username should be equal to the predefined variable", newUsername, user.getName());
	}
}
