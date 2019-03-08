package models;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;


public class SeatTest {

	@Test
	public void testGetSetHallId() {
		Seat seat = new Seat(UUID.randomUUID(), 1, true);
		UUID id = UUID.randomUUID();
		
		seat.setHallId(id);
		
		Assert.assertEquals("The HallId should be equal to the predefined Id", id, (UUID)seat.getHallId());
	}
	
	@Test
	public void testGetSetSeatNumber() {
		Seat seat = new Seat(UUID.randomUUID(), 1, true);
		seat.setSeatNumber(2);
		
		Assert.assertEquals("The Seat Number should be equal to 2", 2, (int)seat.getSeatNumber());
	}
}
