package data.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import data.container.Database;
import models.Hall;
import models.Movie;
import models.Seat;

public class HallRepositoryTest {
	@Test
	public void testGetHallByMovie() {
		Movie movie = Database.getMovies().get(0);
		Hall hall = new HallRepository().getHallByMovie(movie);

		Assert.assertNotNull("Hall should not be null", hall);
	}

	@Test
	public void testPrintHallSeats() {
		HallRepository hallRepository = new HallRepository();

		Hall freeSeatsHall = Database.getHalls().get(0);
		hallRepository.printHallSeats(freeSeatsHall);
		Assert.assertEquals("All seats will be printed as free, because they have a Free state by default", 0,
				freeSeatsHall.getSeats().stream().filter(x -> x.getTaken() == true).count());

		Hall takenSeatsHall = Database.getHalls().get(0);
		List<Seat> seats = takenSeatsHall.getSeats();
		for (Seat seat : seats) {
			seat.setTaken(true);
		}

		takenSeatsHall.setSeats(seats);
		hallRepository.printHallSeats(takenSeatsHall);

		Assert.assertEquals("All seats will be printed as taken, because their state has been updated", 0,
				takenSeatsHall.getSeats().stream().filter(x -> x.getTaken() == false).count());
	}
}
