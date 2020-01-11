import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbase {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/sample";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";

	public void DBSampleCreate() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();
			//create a table in the database
			String sql = "CREATE TABLE Simple "
					+ "(ID varchar(255) NOT NULL, RefID INT NOT NULL, alias BIGINT NOT NULL, "
					+ "Category INT not NULL, Param1 varchar(255), Param2 varchar(255), Param3 varchar(255), "
					+ "Param4 BIGINT, Param5 varchar(255), Param6 varchar(255),Param7 varchar(255), "
					+ "Param8 varchar(255), Param9 varchar(255), Param10 varchar(255),Param11 INT, "
					+ "Param12 varchar(255), Param13 varchar(255), Hour varchar(255), Minute varchar(255), "
					+ "Param14 varchar(255), Param15 varchar(255), Param16 varchar(255), Param17 varchar(255), "
					+ "Param18 varchar(255), Data varchar(255), Comments varchar(255), SubjectNum varchar(255), CheckNo INT NOT NULL, PRIMARY KEY ( ID ))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		}

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void loaddata() {
		String query;

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			query = "LOAD DATA LOCAL INFILE 'simpledatabase.csv' "
					+ "INTO TABLE Simple FIELDS TERMINATED BY ',';";

			stmt.executeUpdate(query);
			System.out.println("Loaded CSV file into table successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			stmt = null;
		}
	}

	public void selectdata() {
		String query;

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// STEP 4: Select the ID, RefID and alias columns but returns only
			// 10 rows.
			query = "Select ID,RefID, alias FROM Simple LIMIT 10;";

			ResultSet rs = stmt.executeQuery(query);
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String id = rs.getString("ID");
				int refID = rs.getInt("RefID");
				int alias = rs.getInt("alias");
				// Display values
				System.out.println("Data from database");
				System.out.println("ID: " + id + ", Age: " + refID + ", First: " + alias);
			}

			// STEP 6: Clean-up environment
			rs.close();

			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			stmt = null;
		}
		System.out.println("Goodbye!");
	}
}
