package models;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class MovieTest {

	@Test
	public void testGetSetName() {
		Movie movie = new Movie("Test", 50, (float) 5.5);
		movie.setName("Test 1");

		Assert.assertEquals("The Name should be equal to Test 1", "Test 1", movie.getName());
	}

	@Test
	public void testGetSetLength() {
		Movie movie = new Movie("Test", 50, (float) 5.5);
		movie.setLength(100);

		Assert.assertEquals("The Length should be equal to 100", 100, (int) movie.getLength());
	}

	@Test
	public void testGetSetProjectionDateTime() {
		Movie movie = new Movie("Test", 50, (float) 5.5);
		LocalDateTime dateTimeNow = LocalDateTime.now();
		movie.setProjectionDateTime(dateTimeNow);

		Assert.assertEquals("The ProjectionDateTime should be equal to the predefined dateTimeNow variable",
				dateTimeNow, (LocalDateTime) movie.getProjectionDateTime());
	}
}
