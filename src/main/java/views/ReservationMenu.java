package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;

import data.repositories.HallRepository;
import data.repositories.MovieRepository;
import data.repositories.ReservationRepository;
import models.Hall;
import models.Movie;
import models.Reservation;
import models.Seat;

/**
 * The ReservationMenu class contains methods which will be used in the reservation menu of the application
 */
public class ReservationMenu extends BaseMenu {
	private MovieRepository _movieRepository;
	private HallRepository _hallRepository;
	private ReservationRepository _reservationRepository;

	public ReservationMenu() {
		_movieRepository = new MovieRepository();
		_hallRepository = new HallRepository();
		_reservationRepository = new ReservationRepository();
	}

	/**
	 * Renders the main menu options in the console
	 */
	public void renderMenu() {
		System.out.println("Enter movie Id:");
		String movieIdInput = readFromConsole();

		Integer movieNumber;
		try {
			movieNumber = Integer.parseInt(movieIdInput);
		} catch (NumberFormatException e) {
			movieNumber = -1;
		}

		Movie movie = _movieRepository.GetById(movieNumber);

		if (movie == null) {
			System.out.flush();
			System.out.println("An error occured, there isn't a movie with the number you've entered! ");
			renderMenu();
		} else {

			Hall hall = _hallRepository.getHallByMovie(movie);

			_movieRepository.renderFullMovieDetails(movie, hall);

			System.out.println();

			if (LocalDateTime.now().plusMinutes(60).compareTo(movie.getProjectionDateTime()) > 0) {
				System.out.println(
						"You can make a reservation for this movie only 60 min before it's projection time.Please select a projection at another time!");

				renderMenu();
			}

			List<Seat> seats;

			while (true) {
				_hallRepository.printHallSeats(hall);
				
				System.out.println("Please select seats (enter each seat number splitted by a ','): ");
				String seatsInput = readFromConsole();
				
				seats = _reservationRepository.tryGetAvialableSeats(seatsInput, hall.getId());

				if (seats == null) {
					_movieRepository.renderMovie(movie);
					System.out.println();
				} else {
					break;
				}
			}

			System.out.println("Please enter your name: ");
			String username = readFromConsole();

			System.out.println("Do you wish you confirm your reservation? (Y/N)");
			String confirmation = readFromConsole();

			if (confirmation.toUpperCase().equals("Y")) {
				_reservationRepository.create(
						new Reservation(username, movie.getId(), LocalDateTime.now(), seats, hall.getId()));

				System.out.println("Your reservation has been submited successfully!");
				System.out.println("Press any key to go back to the main menu.");

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try {
					br.readLine();
					System.out.flush();
					new MainMenu().renderMenu();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				new MovieMenu().renderMenu();
			}

		}
	}
}
