package views;

import org.junit.Assert;
import org.junit.Test;


public class MovieMenuTest {

	@Test
	public void testRenderMenu() {
		MovieMenu menu = new MovieMenu();
		menu.renderMenu();
		
		Assert.assertTrue(true);
	}
}
