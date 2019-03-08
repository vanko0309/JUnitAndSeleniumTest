package data.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import data.container.Database;
import models.Seat;
import models.Hall;
import models.Reservation;

/**
 * The ReservationRepository class provides methods for searching for {@link Reservation} in the DB collection and handling output data
 */
public class ReservationRepository {
	/**
	 * Creates a new reservation and adds it to the Database
	 * @param The {@link Reservation} which is going to be created
	 */
	public void create(Reservation reservation) {
		Database.addReservation(reservation);
		
		Hall hall = Database.getHalls().stream().filter(x -> reservation.getHallId().equals(x.getId())).findFirst().orElse(null);
    	for (Seat seat : reservation.getSeats()) {
    		Integer indexOfSeat = hall.getSeats().indexOf(seat);
    		
    		seat.setTaken(true);
    		hall.getSeats().set(indexOfSeat, seat);
    	}
	}
	
	/**
	 * @param hallId UUID of the hall
	 * @param seatNumber The number of the seat
	 * @return A {@link Seat} if available or NULL if the seat is taken
	 */
	private Seat getAvialableSeatOrNull(UUID hallId, Integer seatNumber) {
		Hall hall = Database.getHalls().stream().filter(x -> hallId.equals(x.getId())).findFirst().orElse(null);
		Seat seat = hall.getSeats().stream().filter(x -> seatNumber.equals(x.getSeatNumber())).findFirst().orElse(null);
		
		if(seat.getTaken()) {
			System.out.println("Seat " + seat.getSeatNumber() + " is already taken. Please select a different seat.");
			return null;
		}
		
		return seat;
	}
	
	/**
	 * @param seatsInput A comma splitted string of numbers
	 * @param hallId UUID of the hall
	 * @return List of {@link Seat} if all the seats are available or NULL
	 */
	public List<Seat> tryGetAvialableSeats(String seatsInput, UUID hallId) {
		String[] seatsInputSplitted = seatsInput.split(",");
		List<Seat> seats = new ArrayList<Seat>();

		for (String seat : seatsInputSplitted) {
			Integer seatNumber;

			try {
				seatNumber = Integer.parseInt(seat);
				seats.add(getAvialableSeatOrNull(hallId, seatNumber));
			} catch (NumberFormatException e) {
				System.out.println(seat + " is not an available seat. Please enter a valid value.");
				return null;
			}
		}
		
		if (seats.contains(null)) {
			return null;
		}
		
		return seats;
	}
}
