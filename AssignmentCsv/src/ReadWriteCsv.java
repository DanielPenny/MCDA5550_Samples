import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWriteCsv {

	public void walk(String path) throws IOException {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				System.out.println("Dir:" + f.getAbsoluteFile());
				walk(f.getAbsolutePath());

			} else {
				final long startTime1 = System.currentTimeMillis();
				System.out.println("File:" + f.getAbsoluteFile());

				if (f.getName().contains(".csv")) {
					BufferedReader in = new BufferedReader(new FileReader(f));
					try {
						in.readLine();
						File newfile = new File("simpledatabase.csv");

						FileWriter filewriter = new FileWriter(newfile, true);
						BufferedWriter out = new BufferedWriter(filewriter);
						String count;
						//reads each line in each of the csv files
						while ((count = in.readLine()) != null) {
							//writes each line into the new csv file
							out.write(count);
							out.newLine();
						}

						Logger.getAnonymousLogger().log(Level.INFO, "Read and Write Time");
						final long endTime = System.currentTimeMillis();
						System.out.println("Total execution time: " + (endTime - startTime1) + " ms");
						//close the buffer writer
						out.close();
						//close the filewriter
						filewriter.close();
					}

					catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (in != null) {
							try {
								//close the reader
								in.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

		}
	}

}
