package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The Hall class describing a movie hall which is playing a movie.
 * The Seats are generated automatically during initialization depending on the hall capacity.
 */
public class Hall {
	private UUID id;
    private Integer hallNumber;
    private Integer capacity;
    private Movie currentPlayingMovie;
    private List<Seat> seats;

    public Hall(Integer hallNumber, Integer capacity, Movie currentPlayingMovie) {
        this.id = UUID.randomUUID();
        this.hallNumber = hallNumber;
        this.capacity = capacity;
        this.currentPlayingMovie = currentPlayingMovie;
        this.seats = new ArrayList<Seat>();

        for (int i = 0; i < this.capacity; i++) {
            this.seats.add(new Seat(this.getId(), (i + 1), false));
        }
    }

    public UUID getId() {
        return this.id;
    }

    public Integer getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(Integer hallNumber) {
        this.hallNumber = hallNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Movie getCurrentPlayingMovie() {
        return currentPlayingMovie;
    }

    public void setCurrentPlayingMovie(Movie currentPlayingMovie) {
        this.currentPlayingMovie = currentPlayingMovie;
    }

    public List<Seat> getSeats() {
        return seats;
    }
    
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    
    public Integer getNumberOfFreeSeats() {
    	return (int)this.seats.stream().filter(x -> x.getTaken() == false).count();
    }
}
