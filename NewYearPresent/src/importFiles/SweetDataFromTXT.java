package importFiles;

import java.io.IOException;
import java.util.ArrayList;

import candies.Sweet;

public class SweetDataFromTXT {

	private String file_name = "sweet.txt";
	private String[] txtLines;

	public ArrayList<Sweet> getSweetFromSource() {
		ArrayList<Sweet> sweets = new ArrayList<Sweet>();
		TXTFileReader file = new TXTFileReader(file_name);
		try {
			txtLines = file.getLinesFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < txtLines.length; i++) {
				System.out.println("Lines with sweet data from txt: " + txtLines[i]);
				String[] sweetParams = txtLines[i].trim().split(":");
				Sweet sweet = new Sweet(sweetParams[0], Integer.parseInt(sweetParams[1]));
				sweets.add(sweet);
			}
		} catch (NullPointerException e) {
			System.out.println(
					"text lines couldn't be read from file or other init issue occured - please refer to stacktrace.");
			e.printStackTrace();
			Sweet sweet = new Sweet("MyFavoriteSweet", 22);
			sweets.add(sweet);
		}
		return sweets;
	}
}
