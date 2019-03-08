package data.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import models.Hall;
import models.Movie;

public class MovieRepositoryTest {

	@Test
	public void testGetById() {
		MovieRepository movieRepository = new MovieRepository();
		Movie movie = movieRepository.GetAll().get(0);
		Movie searchedMovie = movieRepository.GetById(movie.getId());

		Assert.assertEquals("The movie which is found should be equal to the first element of the array.", movie,
				searchedMovie);
	}
	
	@Test
	public void testRenderAllMovies() {
		MovieRepository movieRepository = new MovieRepository();
		movieRepository.renderAllMovies();
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testRenderMovie() {
		MovieRepository movieRepository = new MovieRepository();
		Movie movie = Mockito.mock(Movie.class);
		
		movieRepository.renderMovie(movie);
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testRenderFullMovieDetails() {
		MovieRepository movieRepository = new MovieRepository();
		Movie movie = Mockito.mock(Movie.class);
		Hall hall = Mockito.mock(Hall.class);
		
		movieRepository.renderFullMovieDetails(movie,hall);
		
		Assert.assertTrue(true);
	}
}