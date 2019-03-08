package data.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import data.container.Database;
import models.Reservation;
import models.Seat;

public class ReservationRepositoryTest {

	@Test
	public void testCreate() {
		ReservationRepository reservationRepository = new ReservationRepository();
		
		Reservation reservation = Mockito.mock(Reservation.class);
		when(reservation.getUsername()).thenReturn("Test");
		when(reservation.getMovieId()).thenReturn(Database.getMovies().get(0).getId());
		when(reservation.getReservationDateTime()).thenReturn(LocalDateTime.now());
		when(reservation.getSeats()).thenReturn(new ArrayList<Seat>(Database.getHalls().get(0).getSeats()));
		when(reservation.getHallId()).thenReturn(Database.getHalls().get(0).getId());
		reservationRepository.create(reservation);

		Assert.assertEquals("There should be one reservation", 1, Database.getReservations().size());
	}
	
	@Test
	public void testTryGetAvialableSeats() {
		ReservationRepository reservationRepository = new ReservationRepository();
		
		List<Seat> availableSeats = reservationRepository.tryGetAvialableSeats("1,2,3,4", Database.getHalls().get(0).getId());
		System.out.println(availableSeats.size());
		Assert.assertEquals("The number of available seats should be 4, as they are all free by default.", 4, availableSeats.size());		
		
		reservationRepository.create(new Reservation("Test", Database.getMovies().get(0).getId(), LocalDateTime.now(), availableSeats, Database.getHalls().get(0).getId()));
		
		List<Seat> unavailableSeats = reservationRepository.tryGetAvialableSeats("1,2,3,4", Database.getHalls().get(0).getId());
		Assert.assertEquals("The unavailableSeats variable should be null, as all seats already marked as taken.", null, unavailableSeats);
	}
}