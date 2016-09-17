package multi.thread.entity.persiter;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import multi.thread.jdbc.Entity;

/**
 * 
 * @author jbaba
 *
 */
public class Persister extends Entity{

	@SuppressWarnings("rawtypes")
	List entity = new ArrayList<>();
	List<String> sqlInsert = new ArrayList<>();
	
	public Persister() {
	}

	@SuppressWarnings("unchecked")
	public void add(Object obj){
		entity.add(obj);
	}
	
	public void insert() throws Exception{
		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		for (String query : sqlInsert) {
			statement.addBatch(query);
		}
		statement.executeBatch();
		statement.close();
		connection.close(); 
	}
	
}
