package views;

/**
 * The MainMenu class contains methods which will be used in the main menu of the application
 */
public class MainMenu extends BaseMenu {
	
	/**
	 * Renders the main menu options in the console
	 */
	public void renderMenu() {
		System.out.println("Select a category:");
		System.out.println("1. Movie program");
		System.out.println("2. Exit");
		String input = readFromConsole();

		switch (input) {
		case "1":
			new MovieMenu().renderMenu();
			break;
		case "2":
			System.exit(0);
			break;
		default:
			System.out.println("Invalid selection! Try again!");
			System.out.flush();
			renderMenu();
			break;
		}
	}
}
