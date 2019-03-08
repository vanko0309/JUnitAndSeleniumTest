package models;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * The Movie class describing a movie
 */
public class Movie {
	private Integer id;
	private String name;
	private Integer length;
	private LocalDateTime projectionDateTime;

	public Movie(String name, Integer length, Float grade) {
		this.id = (int)(Math.random() * 100 + 1);
		this.name = name;
		this.length = length;
		this.projectionDateTime = this.generateProjectionDateTime();
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public LocalDateTime getProjectionDateTime() {
		return projectionDateTime;
	}

	public void setProjectionDateTime(LocalDateTime projectionDateTime) {
		this.projectionDateTime = projectionDateTime;
	}

	public LocalDateTime generateProjectionDateTime() {
		Random rnd = new Random();

		int dayNumber = LocalDateTime.now().getDayOfMonth();
		String day = getCorrectValue(dayNumber, Integer.toString(dayNumber));

		int hourNumber = rnd.nextInt(23);
		String hour = getCorrectValue(hourNumber, Integer.toString(hourNumber));

		int minuteNumber = rnd.nextInt(60);
		String minute = getCorrectValue(minuteNumber, Integer.toString(minuteNumber));

		String date = MessageFormat.format("2019-02-{0} {1}:{2}", day, hour, minute);
		return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}

	private String getCorrectValue(Integer numericValue, String stringValue) {
		if (numericValue < 10) {
			stringValue = "0" + stringValue;
		}

		return stringValue;
	}
}
