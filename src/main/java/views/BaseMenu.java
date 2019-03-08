package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The BaseMenu class contains methods which will be used in all classes which inherit it
 */
public class BaseMenu {
	/**
	 * Reads the user input from the console
	 * @return The {@link String} of user input if it is valid or NULL
	 */
	public String readFromConsole() {
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
            return input;
        } catch (IOException e) {
            System.out.println("Invalid string");
            e.printStackTrace();
        }
        return null;
    }
}
