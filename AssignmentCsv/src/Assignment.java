import java.io.IOException;

public class Assignment {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//call the walk function in the ReadWriteCsv class
		ReadWriteCsv fw = new ReadWriteCsv();
		fw.walk("datafiles");
		//call the functions in the Dbase class
		Dbase db = new Dbase();
		db.DBSampleCreate();
		db.loaddata();
		db.selectdata();
		//call the getCsvdata function in the CsvParser class
		CsvParser cp = new CsvParser();
		cp.getCsvdata();
	}

}
