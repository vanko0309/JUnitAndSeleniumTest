package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import data.container.Database;

public class HallTest {

	private Hall hall;

	@Before
	public void setUp() {
		this.hall = Mockito.mock(Hall.class);

		when(hall.getHallNumber()).thenReturn(1);
		when(hall.getCapacity()).thenReturn(10);
		when(hall.getCurrentPlayingMovie()).thenReturn(Database.getMovies().get(0));
	}

	@Test
	public void testGetHallNumber() {
		Assert.assertEquals("The the first hall number should be 1", 1, (int) hall.getHallNumber());
	}

	@Test
	public void testSetHallNumber() {
		Hall h = new Hall(2, 10, Database.getMovies().get(0));
		h.setHallNumber(3);
		Assert.assertEquals("The hall number should be 3", 3, (int) h.getHallNumber());
	}

	@Test
	public void testSetCapacity() {
		Hall h = new Hall(1, 10, Database.getMovies().get(0));
		h.setCapacity(20);
		Assert.assertEquals("The capacity should be set to 20", 20, (int) h.getCapacity());
	}

	@Test
	public void testSetCurrentPlayingMovie() {
		Hall h = new Hall(1, 10, Database.getMovies().get(0));
		h.setCurrentPlayingMovie(Database.getMovies().get(1));
		Assert.assertEquals("The movie should be equal to the passed movie", Database.getMovies().get(1), h.getCurrentPlayingMovie());
	}

	@Test
	public void testGetNumberOfFreeSeats() {
		Hall h = new Hall(1, 10, Database.getMovies().get(0));
		Assert.assertEquals("The free seats should be equal to the total number of seats in the room", 10, (int) h.getNumberOfFreeSeats());
	}
}
