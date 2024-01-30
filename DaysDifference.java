package com.java.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DaysDifference {
	public static void main(String[] args) {
		String firstDate="29-01-2024";
		System.out.println(" First Date : "+firstDate);
		String secondDate="31-01-2024";
		System.out.println(" Second Date : "+secondDate);
		System.out.println(" Days difference between the dates : "+ daysDiff(firstDate, secondDate)+" Days ");
	}

	public static long daysDiff(String date1, String date2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate d1 = LocalDate.parse(date1, formatter);
		LocalDate d2 = LocalDate.parse(date2, formatter);
		return ChronoUnit.DAYS.between(d1, d2);
	}
}