package views;

import data.repositories.MovieRepository;

/**
 * The MovieMenu class contains methods which will be used in the movie menu of the application
 */
public class MovieMenu extends BaseMenu {
	private MovieRepository _movieRepository;
	
	public MovieMenu() {
		_movieRepository = new MovieRepository();
	}
	
	/**
	 * Renders the movie menu options in the console
	 */
	public void renderMenu() {
		_movieRepository.renderAllMovies();
		
		System.out.println("Select an option:");
		System.out.println("1. Make a reservation");
		System.out.println("2. Go back");
		String input = readFromConsole();

		switch (input) {
		case "1":
			new ReservationMenu().renderMenu();
			break;
		case "2":
			new MainMenu().renderMenu();
			break;
		default:
			System.out.println("Invalid selection! Try again!");
			renderMenu();
			break;
		}
	}
}
