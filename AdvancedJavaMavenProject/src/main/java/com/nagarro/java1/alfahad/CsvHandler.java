package com.nagarro.java1.alfahad;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CsvHandler {
	public static Set<Tshirt> tData = new HashSet<>();
	static List<String> filenames = new LinkedList<String>();

	public static void listFilesfolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.getName().contains(".csv")) {
				filenames.add(fileEntry.getName());

			}
		}
	}

	public static void loadData() throws IOException, CsvException {
		String str = "C:\\Users\\md-alfahadansari\\eclipse-workspace\\AdvancedJavaMavenProject\\src\\test\\resources\\";
		final File folder = new File(str);
		listFilesfolder(folder);
		for (String filename : filenames) {
			Reader reader = new FileReader(str + filename);
			tData.addAll(readCSV(reader));

		}
	}

	public static List<Tshirt> readCSV(Reader reader) throws IOException, CsvException {
		List<Tshirt> tshirtList = new LinkedList<>();
		CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
		CSVReader read = new CSVReaderBuilder(reader).withCSVParser(parser).build();
		String[] xyz = read.readNext();
		xyz = read.readNext();
		while (xyz != null) {
			Tshirt tshirt = new Tshirt();
			tshirt.setID(xyz[0]);
			tshirt.setNAME(xyz[1]);
			tshirt.setCOLOUR(xyz[2]);
			tshirt.setGENDER_RECOMMENDATION(xyz[3]);
			tshirt.setSIZE(xyz[4]);
			tshirt.setPRICE(Double.parseDouble(xyz[5]));
			tshirt.setRATING(Double.parseDouble(xyz[6]));
			tshirt.setAVAILIBILITY(xyz[7]);
			tshirtList.add(tshirt);
			xyz = read.readNext();
		}
		reader.close();
		read.close();
		return tshirtList;
	}

}
