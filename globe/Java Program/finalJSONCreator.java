package regex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class finalJSONCreator {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		File longitude = new File("C:\\Users\\zackk\\Documents\\Capital One\\coordinates\\longitude.txt");
		File latitude = new File("C:\\Users\\zackk\\Documents\\Capital One\\coordinates\\latitude.txt");
		File Chupacabralongitude = new File(
				"C:\\Users\\zackk\\Documents\\Capital One\\ChupacabraCoordinates\\Chupacabralongitude.txt");
		File Chupacabralatitude = new File(
				"C:\\Users\\zackk\\Documents\\Capital One\\ChupacabraCoordinates\\ChupacabraLatitude.txt");
		Scanner chupacabraScLong = new Scanner(Chupacabralongitude);
		Scanner chupacabrScLat = new Scanner(Chupacabralatitude);
		//Counters are kept since all data sets do not have an equal number of data points
		int totalCount = 0;
		int bigfootCount = 0;
		int chupacabraCount = 0;

		Scanner scLong = new Scanner(longitude);
		StringBuffer jsonFile = new StringBuffer();
		// Data for all the creatures is stored in All Data
		jsonFile.append("[[" + "\"All Data\"" + ",["); // beginning formatting for
													// the json file
		Scanner scLat = new Scanner(latitude);

		while (scLong.hasNext() && scLat.hasNext()) {
			jsonFile.append(scLat.next() + ',');
			jsonFile.append(scLong.next() + ',');
			jsonFile.append("0.1,");
			totalCount++;
		}

		while (chupacabraScLong.hasNext() && chupacabrScLat.hasNext()) {
			jsonFile.append(chupacabraScLong.next() + ',');
			jsonFile.append(chupacabrScLat.next() + ',');
			jsonFile.append("0.25,");
			totalCount++;
		}
		jsonFile.append("57.3229,4.4244,0.5");
		totalCount++;

		// Just Bigfoot Data is stored in Bigfoot
		jsonFile.append("]],[" + "\"Bigfoot\"" + ",[");
		scLong = new Scanner(longitude);
		scLat = new Scanner(latitude);
		while (scLong.hasNext() && scLat.hasNext()) {
			jsonFile.append(scLat.next() + ',');
			jsonFile.append(scLong.next() + ',');
			jsonFile.append("0.1,");
			bigfootCount++;
		}
		for (int i = 0; i < totalCount - bigfootCount; i++) {
			jsonFile.append("0,0,0,");
		}
		jsonFile.setLength(jsonFile.length() - 1);

		// Just Chupacabra Data is stored in Chupacabra
		chupacabraScLong = new Scanner(Chupacabralongitude);
		chupacabrScLat = new Scanner(Chupacabralatitude);
		jsonFile.append("]],[" + "\"Chupacabra\"" + ",[");
		while (chupacabraScLong.hasNext() && chupacabrScLat.hasNext()) {
			jsonFile.append(chupacabraScLong.next() + ',');
			jsonFile.append(chupacabrScLat.next() + ',');
			jsonFile.append("0.25,");
			chupacabraCount++;
		}
		for (int i = 0; i < totalCount - chupacabraCount; i++) {
			jsonFile.append("0,0,0,");
		}

		jsonFile.setLength(jsonFile.length() - 1);

		// Just Nessie Data is stored in Nessie
		jsonFile.append("]],[" + "\"Nessie\"" + ",[");
		jsonFile.append("57.3229,4.4244,0.5,");

		for (int i = 0; i < totalCount - 1; i++) {
			jsonFile.append("0,0,0,");
		}

		jsonFile.setLength(jsonFile.length() - 1);
		jsonFile.append("]]]");

		System.out.print(jsonFile);

		File b = new File("C:\\Users\\zackk\\Documents\\Capital One\\coordinates\\newfile.json");
		b.createNewFile();
		FileWriter fw = new FileWriter(b);
		fw.write(jsonFile.toString());
		fw.flush();
		fw.close();
		System.out.println("wrote to file");

	}

}
