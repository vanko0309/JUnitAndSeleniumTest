package data.container;

import models.Reservation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DatabaseTest {
	
	@Test
	public void testInitilalizeDatabase() {
		Assert.assertTrue("Should initialize Database", new Database() != null);
	}

	@Test
	public void testGetHalls() {
		Assert.assertNotNull("Collection of halls should not be null", Database.getHalls());
		Assert.assertEquals("All halls must be 9", 9, Database.getHalls().size());
	}

	@Test
	public void testAllHallsShouldHaveMovies() {
		Assert.assertTrue("All halls should have assigned movies",
				Database.getHalls().stream().allMatch(h -> h.getCurrentPlayingMovie() != null));
	}

	@Test
	public void testAllHallsShouldHaveSeats() {
		Assert.assertTrue("All halls should have assigned seats",
				Database.getHalls().stream().allMatch(h -> h.getSeats() != null));
	}

	@Test
	public void testAllHallsShouldHaveEqualSeatsAsHallSize() {
		Assert.assertTrue("Number of seats should be the same as hall size",
				Database.getHalls().stream().allMatch(h -> h.getSeats().size() == h.getCapacity()));
	}

	@Test
	public void testGetMovies() {
		Assert.assertNotNull("Collection of movies should not be null", Database.getMovies());
		Assert.assertEquals("All movies must be 9", 9, Database.getMovies().size());
	}

	@Test
	public void testGetReservations() {
		Assert.assertNotNull("Collection of reservations should not be null", Database.getReservations());
		Assert.assertEquals("Initially, there should be no reservations", 0, Database.getReservations().size());

		Reservation r = Mockito.mock(Reservation.class);
		Database.addReservation(r);

		Assert.assertEquals("There should be one reservation", 1, Database.getReservations().size());
	}

	@Test
	public void testAddReservation() {
		Reservation r = Mockito.mock(Reservation.class);
		Database.addReservation(r);

		Assert.assertEquals("There should be one reservation", 1, Database.getReservations().size());
	}
}
