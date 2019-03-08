package data.repositories;

import java.util.List;

import data.container.Database;
import models.Hall;
import models.Movie;

/**
 * The MovieRepository class provides methods for searching for {@link Movie} in
 * the DB collection and handling output data
 */
public class MovieRepository {
	public Movie GetById(Integer id) {
		return Database.getMovies().stream().filter(x -> id.equals(x.getId())).findFirst().orElse(null);
	}

	/**
	 * @return A list of {@link Movie}
	 */
	public List<Movie> GetAll() {
		return Database.getMovies();
	}

	/**
	 * Prints in the console all the available movies.
	 */
	public void renderAllMovies() {
		List<Movie> movies = Database.getMovies();

		for (Movie movie : movies) {
			System.out.println("===== Movie =====");
			System.out.println("Number: " + movie.getId());
			System.out.println("Title: " + movie.getName());
			System.out.println("Lenght: " + movie.getLength());
			System.out.println("Projection time: " + movie.getProjectionDateTime());
			System.out.println("=========================");
		}
	}

	/**
	 * Prints in the console a {@link Movie}
	 * @param The {@link Movie} for which you want to get printed details
	 */
	public void renderMovie(Movie movie) {
		System.out.println("===== Movie Details =====");
		System.out.println("Title: " + movie.getName());
		System.out.println("Lenght: " + movie.getLength());
		System.out.println("Projection time: " + movie.getProjectionDateTime());
		System.out.println("=========================");
	}

	/**
	 * Prints in the console details about a {@link Movie}
	 * @param The {@link Movie} which is going to be projected
	 * @param The {@link Hall} in which the movie is going to be projected
	 */
	public void renderFullMovieDetails(Movie movie, Hall hall) {
		System.out.println("===== Movie Details =====");
		System.out.println("Id: " + movie.getId());
		System.out.println("Title: " + movie.getName());
		System.out.println("Lenght: " + movie.getLength());
		System.out.println("Hall: " + hall.getHallNumber());
		System.out.println("Free seats: " + hall.getNumberOfFreeSeats());
		System.out.println("Projection time: " + movie.getProjectionDateTime());
		System.out.println("=========================");
	}
}
