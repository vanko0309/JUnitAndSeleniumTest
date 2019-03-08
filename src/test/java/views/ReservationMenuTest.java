package views;

import org.junit.Assert;
import org.junit.Test;


public class ReservationMenuTest {

	@Test
	public void testRenderMenu() {
		ReservationMenu menu = new ReservationMenu();
		menu.renderMenu();
		
		Assert.assertTrue(true);
	}
}
