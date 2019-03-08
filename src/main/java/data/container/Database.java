package data.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Hall;
import models.Movie;
import models.Reservation;

/**
 * The Database class is used to generate and store in-memory data.
 * The class generates a list of movies and halls when an instance is created and then assigns
 * a movie to each hall.
 */
public final class Database {
	private static List<Movie> movies = Database.generateMovies();
    private static List<Hall> halls = Database.generateHalls();
    private static List<Reservation> reservations = new ArrayList<Reservation>();

    /**
     * @return A list of all {@link Hall}
     */
    public static List<Hall> getHalls() {
        return Database.halls;
    }

    /**
     * @return A list of all {@link Movie}
     */
    public static List<Movie> getMovies() {
        return Database.movies;
    }

    /**
     * @return A list of all {@link Reservation}
     */
    public static List<Reservation> getReservations() {
        return Database.reservations;
    }

    /**
     * @param reservation {@link Reservation} to be deleted
     */
    public static void addReservation(Reservation reservation) {
    	Database.reservations.add(reservation);
    }

    /**
     * Generates a hall for each movie and assigns the movie to the specific hall
     * @return A list of {@link Hall} with an assigned movie
     */
    private static List<Hall> generateHalls() {
        List<Hall> halls = new ArrayList<>();
        int hallNumber = 1;
        for (Movie movie : Database.movies) {
            halls.add(new Hall(hallNumber, 20, movie));
            hallNumber++;
        }

        return halls;
    }

    /**
     * @return A list of {@link Movie}
     */
    private static List<Movie> generateMovies() {
        return Arrays.asList(
                new Movie("Spider-man", 120, 7.2f),
                new Movie("Batman", 140, 5.1f),
                new Movie("Hulk", 90, 8.1f),
                new Movie("And-man", 210, 6.7f),
                new Movie("Captain America", 100, 9.0f),
                new Movie("Black Panther", 160, 8.8f),
                new Movie("Thor", 80, 6.3f),
                new Movie("Venom", 140, 8.3f),
                new Movie("Deadpool", 150, 9.3f)
        );
    }
}
