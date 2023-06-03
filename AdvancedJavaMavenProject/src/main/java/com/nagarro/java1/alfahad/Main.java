package com.nagarro.java1.alfahad;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.opencsv.exceptions.CsvException;

public class Main {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		String ch;
		do {

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the color:");
			String color = sc.nextLine().toUpperCase();
			System.out.println("Enter the size:");
			String size = sc.nextLine().toUpperCase();
			System.out.println("Enter the gender:");
			String gender = sc.nextLine();
			System.out.println("Enter the output preference:");
			String output_preference = sc.nextLine();

			CsvHandler.loadData();
			List<Tshirt> listofdata = CsvHandler.tData.stream()
					.filter(x -> color.equalsIgnoreCase(x.getCOLOUR()) && size.equalsIgnoreCase(x.getSIZE())
							&& gender.equalsIgnoreCase(x.getGENDER_RECOMMENDATION()))
					.sorted(Comparator.comparingDouble(x -> output_preference.equalsIgnoreCase("rating") ? x.getRATING()
							: output_preference.equalsIgnoreCase("price") ? x.getPRICE()
									: x.getRATING() * x.getPRICE()))
					.collect(Collectors.toList());
			System.out.println(listofdata);
			System.out.println("do you want to repeat this y/n");
			System.out.println("enter y or n");
			ch = sc.next();
		} while (ch.equalsIgnoreCase("y"));
	}
}
