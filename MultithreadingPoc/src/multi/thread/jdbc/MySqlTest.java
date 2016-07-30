package multi.thread.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * My Sql Test connection example
 * @author jbaba
 *
 */
public class MySqlTest {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/OCricket";
		String username = "java";
		String password = "password";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
	}

}
