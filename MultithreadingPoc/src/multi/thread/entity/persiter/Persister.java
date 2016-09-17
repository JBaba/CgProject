package multi.thread.entity.persiter;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import multi.thread.entity.IEntity;
import multi.thread.jdbc.Entity;

/**
 * 
 * @author jbaba
 *
 */
public class Persister extends Entity{

	List<IEntity> entity = new ArrayList<>();
	// all insert sqls
	List<String> sqlInsert = new ArrayList<>();
	
	public Persister() {
	}

	/**
	 * Add method to insert
	 * @param obj
	 */
	public void add(IEntity obj){
		entity.add(obj);
		sqlInsert.add(obj.getInsert());
	}
	
	/**
	 * Insert all using batch commit
	 * @throws Exception
	 */
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
