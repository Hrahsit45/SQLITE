import java.util.Scanner;

import java.sql.*;

class Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String flag="Y";

		do{

		System.out.println("Select DML Operation For MOVIE_DB Table...");

		System.out.println("1. Insert");

		System.out.println("2. Select");

		System.out.println("3. Exit");

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter a choice: ");

		int n = reader.nextInt();

		Connection c = null;

		Statement stmt = null;

		try {

		Class.forName("org.sqlite.JDBC");

		c = DriverManager.getConnection("jdbc:sqlite:/home/vegita/sqlite/db/movie.db");
		
		c.setAutoCommit(false);

		stmt = c.createStatement();

		String movie_name ="", sql="";

		String lead_actor = ""; 
		
		String lead_actress = ""; 
		
		String Dir_Name = ""; 
		
		String  Release_Date = ""; 
		
		int id;

		Scanner scanName;

		switch(n){

		 

		case 1:

		scanName=new Scanner(System.in);

		System.out.println("Enter movie Name:");

		movie_name=scanName.nextLine();

		System.out.println("Enter lead actor");

		lead_actor=scanName.nextLine();
		
		System.out.println("Enter lead actress:");

        lead_actress=scanName.nextLine();
        
        System.out.println("Enter Director:");

        Dir_Name =scanName.nextLine();
        
        System.out.println("Enter Realease date:");

        Release_Date =scanName.nextLine();

		sql = "INSERT INTO MOVIE_DB (movie_name,lead_actor,lead_actress,Dir_Name,Release_Date) " +

		"VALUES ('" +movie_name+ "','" +

        lead_actor + "','" + lead_actress +  "','" + Dir_Name + "','" + Release_Date + "'" + ")";

		stmt.executeUpdate(sql);

		System.out.println("Inserted Successfully!!!");

		break;

		 
		 

		case 2:

		ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIE_DB;");

		System.out.println("ID\t Movie_name\t\t lead_Actor\t lead_actress\t Dir_Name\t Release_Date");

		while ( rs.next() ) {

		id = rs.getInt("p_id");

		movie_name = rs.getString("movie_name");

		lead_actor = rs.getString("lead_actor");

		lead_actress = rs.getString("lead_actress");
		
		Dir_Name = rs.getString("Dir_Name");
		
		Release_Date = rs.getString("Release_Date");

		System.out.println(id+"\t "+movie_name+" \t "+lead_actor+"\t "+lead_actress+"\t "+Dir_Name+"\t "+Release_Date);

		}

		rs.close();

		break;

		 

		case 3:

		System.exit(0);

		break;

		 

		default:

		System.out.println("Oops!!! Wrong Choice...");

		break;

		}

		stmt.close();

		c.commit();

		c.close();

		}

		catch ( Exception e )

		{

		System.err.println( e.getClass().getName() + ": " + e.getMessage() );

		System.exit(0);

		}

		 

		System.out.println("Continue Y OR N?");

		reader=new Scanner(System.in);

		flag=reader.nextLine();

		 

		}while(flag.equalsIgnoreCase("Y"));

		System.exit(0);

		}
	}


