import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CsvParser {

	public void getCsvdata() {
		//outputs from the csv file file created
		Reader in;
		try {
			in = new FileReader("simpledatabase.csv");
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			int n = 0;
			for (CSVRecord record : records) {
				
				if (n < 10) {
					String id = record.get(0);
					String refID = record.get(1);
					String refID2 = record.get(2);
					System.out.println("Data from csv file");
					System.out.println("Data: " + id + " : " + refID + " : " + refID2);
				} else {
					break;
				}
				
				n++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
