package importFiles;

import java.io.IOException;



import java.io.FileReader;
import java.io.BufferedReader;

public class TXTFileReader {
	private String path;

	public TXTFileReader(String file_path) {
		path = file_path;
	}

	public String[] getLinesFromFile() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);

		int numberOfLines = readnLinesNumber();
		String[] textData = new String[numberOfLines];

		int i;

		for (i = 0; i < numberOfLines; i++) {
			textData[i] = textReader.readLine();
		}

		textReader.close();
		return textData;
	}

	int readnLinesNumber() throws IOException {
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);

		int numberOfLines = 0;

		while (bf.readLine() != null) {
			numberOfLines++;
		}
		bf.close();
		return numberOfLines;
	}
	

		
}
