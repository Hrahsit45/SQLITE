import java.sql.*;

public class table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = null;

		Statement stmt = null;

		try {

		Class.forName("org.sqlite.JDBC");

		c = DriverManager.getConnection("jdbc:sqlite:/home/vegita/sqlite/db/movie.db");

		System.out.println("Database Opened...\n");

		stmt = c.createStatement();

		String sql = "CREATE TABLE MOVIE_DB " +

		"(p_id INTEGER PRIMARY KEY AUTOINCREMENT," +

		" movie_name TEXT NOT NULL, " +

		" lead_actor TEXT NOT NULL, " +

		" lead_actress TEXT NOT NULL, " +
		
		" Dir_Name TEXT NOT NULL," + 
		
		" Release_Date TEXT NOT NULL)" ;
		

		stmt.executeUpdate(sql);

		stmt.close();

		c.close();

		}

		catch ( Exception e ) {

		System.err.println( e.getClass().getName() + ": " + e.getMessage() );

		System.exit(0);

		}

		System.out.println("Table MOVIE_DB Created Successfully!!!");

		}

	}


