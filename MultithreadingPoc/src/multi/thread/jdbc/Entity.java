package multi.thread.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Base class to get connection in project
 * @author jbaba
 *
 */
public class Entity {
    protected Connection getConnection() throws SQLException {
        String pass = "password";
        String userDB = "java";
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/OCricket", userDB, pass);
        return conn;
    }

    protected ResultSet getResultSet(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        return st.executeQuery(sql);
    }
}
