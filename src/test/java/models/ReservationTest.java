package models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import data.container.Database;

public class ReservationTest {

	@Test
	public void testCreateNewReservation() {
		Reservation reservation = new Reservation("Username", 1, LocalDateTime.now(), Database.getHalls().get(0).getSeats(), UUID.randomUUID());

		Assert.assertNotEquals("The resrvation variable should not be null.", null, reservation);
	}

	@Test
	public void testGetSetUsername() {
		Reservation reservation = new Reservation("Username", 1, LocalDateTime.now(), Database.getHalls().get(0).getSeats(), UUID.randomUUID());
		String newUsername = "New Username";
		reservation.setUsername(newUsername);

		Assert.assertEquals("The resrvation name should be equal to the predefined variable.", newUsername,
				reservation.getUsername());
	}

	@Test
	public void testGetSetMovieId() {
		Reservation reservation = new Reservation("Username", 1, LocalDateTime.now(), Database.getHalls().get(0).getSeats(), UUID.randomUUID());
		reservation.setMovieId(2);
		
		Assert.assertEquals("The resrvation MovieId should be equal to 2.", 2, (int)reservation.getMovieId());
	}

	@Test
	public void testGetSetReservationDateTime() {
		Reservation reservation = new Reservation("Username", 1, LocalDateTime.now(), Database.getHalls().get(0).getSeats(), UUID.randomUUID());
		LocalDateTime reservationDateTime = LocalDateTime.now();
		reservation.setReservationDateTime(reservationDateTime);

		Assert.assertEquals("The resrvationDateTime should not be equal to the predefined variable.",
				reservationDateTime, (LocalDateTime) reservation.getReservationDateTime());
	}

	@Test
	public void testGetSetSeat() {
		Reservation reservation = new Reservation("Username", 1, LocalDateTime.now(), Database.getHalls().get(0).getSeats(), UUID.randomUUID());
		List<Seat> newSeats = Database.getHalls().get(2).getSeats();
		reservation.setSeats(newSeats);

		Assert.assertEquals("The seats should be equal.", newSeats, reservation.getSeats());
	}

	@Test
	public void testGetSetHallId() {
		Reservation reservation = new Reservation("Username", 1, LocalDateTime.now(), Database.getHalls().get(0).getSeats(), UUID.randomUUID());
		UUID newUUID = UUID.randomUUID();
		reservation.setHallId(newUUID);

		Assert.assertEquals("The hallId should be equal to the predefined variable.", newUUID,
				(UUID) reservation.getHallId());
	}
}
