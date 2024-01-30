package com.java.practice;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeToWordConverter {

	public static void main(String[] args) {
		// Input Date Time
		String inputDateTime = "29-01-2024 10:10";

		// Parse input date-time string
		LocalDateTime dateTime = parseDateTime(inputDateTime);

		// Format date-time to desired output
		String outputText = formatDateTime(dateTime);

		// Print the result
		System.out.println("Input Date Time: " + inputDateTime);
		System.out.println("Output: " + outputText);
	}

	private static LocalDateTime parseDateTime(String dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		return LocalDateTime.parse(dateTime, formatter);
	}

	private static String formatDateTime(LocalDateTime dateTime) {
		String formattedYear = formatYear(dateTime.getYear());
		String hours = formatHours(dateTime.getHour());
		String minutes = formatHours(dateTime.getMinute());

		DateTimeFormatter outputFormatter = DateTimeFormatter
				.ofPattern("d'th of' MMMM '" + formattedYear + "' '"+ hours+"' 'hours past' '"+ minutes+"' 'minutes'");
		return dateTime.format(outputFormatter);
	}

	private static String formatHours(int hour) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "teen");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		map.put(20, "twenty");
		map.put(30, "thirty");
		map.put(40, "forty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninty");
		
		return map.get(hour);
	}

	private static String formatYear(int year) {
		String[] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] teens = { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"nineteen" };
		String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		if (year >= 1000 && year <= 9999) {
			int thousand = year / 1000;
			int hundred = (year % 1000) / 100;
			int ten = (year % 100) / 10;
			int unit = year % 10;

			StringBuilder sb = new StringBuilder();
			if (thousand > 0) {
				sb.append(units[thousand]).append(" thousand ");
			}
			if (hundred > 0) {
				sb.append(units[hundred]).append(" hundred ");
			}
			if (ten > 1) {
				sb.append(tens[ten]);
				if (unit > 0) {
					sb.append(" ").append(units[unit]);
				}
			} else if (ten == 1) {
				sb.append(teens[unit - 1]);
			} else if (unit > 0) {
				sb.append(units[unit]);
			}
			return sb.toString().trim();
		} else {
			return String.valueOf(year);
		}
	}
}