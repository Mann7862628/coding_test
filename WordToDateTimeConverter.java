package com.java.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WordToDateTimeConverter {

	private static Map<String, Integer> map = new HashMap<String, Integer>();
	static {
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		map.put("ten", 10);
		map.put("eleven", 11);
		map.put("twelve", 12);
		map.put("thirteen", 13);
		map.put("fourteen", 14);
		map.put("fifteen", 15);
		map.put("sixteen", 16);
		map.put("seventeen", 17);
		map.put("eighteen", 18);
		map.put("ninteen", 19);
		map.put("twenty", 20);
		map.put("thirty", 30);
		map.put("forty", 40);
		map.put("fifty", 50);
		map.put("sixty", 60);
		map.put("seventy", 70);
		map.put("eighty", 80);
		map.put("ninety", 90);
	}

	public static String convertTextToDateTime(String text) {
		try {
			// Splitting the input text to extract date and time components
			String[] parts = text.split(" ");

			// Extracting day, month, and year
			int day = extractDay(parts[0]);
			String month = parts[2];
			int year = extractYear(parts);

			// Extracting hour and minute
			int hour = map.get(parts[7]);
			int minute = map.get(parts[10]);

			// Creating a Calendar instance and setting the extracted components
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, day);
			calendar.set(Calendar.MONTH, getMonthIndex(month));
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, minute);

			// Formatting the date and time as per the desired output
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			return outputFormat.format(calendar.getTime());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}

	private static int extractDay(String dayString) {
		// Extracting the numeric part of the day
		return Integer.parseInt(dayString.replaceAll("[^0-9]", ""));
	}

	private static int extractYear(String[] parts) {
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equalsIgnoreCase("thousand")) {
				p1 = 2000;
			} else {
				if (i == 5 || i == 6) {
					p2 = p2 + map.get(parts[i]);
				}
			}

		}
		if (p1 + p2 > 0) {
			return p1 + p2;
		}
		// If no valid year found, throw an exception
		throw new NumberFormatException("Invalid year format");
	}

	private static int getMonthIndex(String month) {
		String[] months = new SimpleDateFormat("MMMM", Locale.ENGLISH).getDateFormatSymbols().getMonths();
		for (int i = 0; i < months.length; i++) {
			if (months[i].equalsIgnoreCase(month)) {
				return i;
			}
		}
		return 0; // Default to January if month is not found
	}

	public static void main(String[] args) {
		String inputText = "29th of January two thousand twenty four ten hours past ten minutes";
		String output = convertTextToDateTime(inputText);

		if (output != null) {
			System.out.println("Output: " + output);
		}
	}
}