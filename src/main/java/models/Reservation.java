package models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * The Reservation class contains the information for a reservation in a specific hall, for a specific movie, on a specific date
 */
public class Reservation {
	private UUID id;
    private String Username;
    private Integer movieId;
    private UUID hallId;
    private LocalDateTime reservationDateTime;
    private List<Seat> Seats;

    public Reservation(String username, Integer movieId, LocalDateTime reservationDateTime, List<Seat> seats, UUID hallId) {
        this.id = UUID.randomUUID();
        this.Username = username;
        this.movieId = movieId;
        this.reservationDateTime = reservationDateTime;
        this.Seats = seats;
        this.hallId = hallId;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public List<Seat> getSeats() {
        return Seats;
    }

    public void setSeats(List<Seat> seats) {
        this.Seats = seats;
    }

    public UUID getHallId() {
        return hallId;
    }

    public void setHallId(UUID hallId) {
        this.hallId = hallId;
    }
}
