package data.repositories;

import data.container.Database;
import models.Hall;
import models.Movie;

/**
 * The HallRepository class provides methods for searching for {@link Hall} in the DB collection and handling output data
 */
public class HallRepository {
	/**
	 * @param {@link Movie} by which will be searched for a hall
     * @return A single {@link Hall} or NULL if the hall is not found
     */
	public Hall getHallByMovie(Movie movie) {
		return Database.getHalls().stream().filter(x -> movie.getId().equals(x.getCurrentPlayingMovie().getId()))
				.findFirst().orElse(null);
	}
	
	/**
     * Prints all the available and taken seats in the console
     * @param The {@link Hall} for which the seats are going to be printed
     */
	public void printHallSeats(Hall hall) {
		Integer numberOfSeats = hall.getSeats().size();
		
		for (int i = 1; i <= numberOfSeats; i++) {
			if(hall.getSeats().get(i - 1).getTaken() == true) {
				if (i% 4 == 0) {
					if(i > 10) {
						System.out.println(" [" + i + "]  ");
					} else {
						System.out.println("  [" + i + "]  ");
					}
				} else {
					if(i > 10) {
						System.out.print(" [" + i + "]  ");
					} else {
						System.out.print("  [" + i + "]  ");
					}
				}
			} else {
				if (i% 4 == 0) {
					if(i > 10) {
						System.out.println("  " + i + "   ");
					} else {
						System.out.println("   " + i + "   ");
					}
				} else {
					if(i > 10) {
						System.out.print("  " + i + "   ");
					} else {
						System.out.print("   " + i + "   ");
					}
					
				}
			}
		}
	}
}
