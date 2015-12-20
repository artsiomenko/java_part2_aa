package importDataBase;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import candies.Sweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectDataBase {
	public static List<Sweet> loadSweets() {
		List<Sweet> sweets = new ArrayList<Sweet>();
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:SWEET_DB");
			stmt = c.createStatement();
			
			String sql = "SELECT * FROM CANDIES;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sweets.add(new Sweet(rs.getString("name"), rs.getInt("weight")));
			}

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return sweets;
	}

	public static void impotrDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:SWEET_DB");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO CANDIES (NAME,WEIGHT) " + "VALUES ('Paul', 32);";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO CANDIES (NAME,WEIGHT) " + "VALUES ('Allen', 25);";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO CANDIES (NAME,WEIGHT) " + "VALUES ('GRILIAZH', 35);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
}
