package multi.thread.entity.persiter;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import multi.thread.entity.IEntity;
import multi.thread.jdbc.Entity;
import multi.thread.logs.CategoryLoggerMultipaleFiles.LogCategory;
import multi.thread.logs.ILog;

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
	 * Clear lists
	 * @param obj
	 */
	public void clear(){
		entity.clear();
		sqlInsert.clear();
	}
	
	/**
	 * Insert all using batch commit
	 * @throws Exception
	 */
	public void insert() throws Exception{
		
		try{
			ILog.iclog(LogCategory.BatchInsert, "Batch Insert started...");
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			
			ILog.iclog(LogCategory.BatchInsert, "Size:"+sqlInsert.size());
			for (String query : sqlInsert) {
				ILog.iclog(LogCategory.BatchInsert, query);
				statement.addBatch(query);
			}
			
			ILog.iclog(LogCategory.BatchInsert, "execute..");
			statement.executeBatch();
			statement.close();
			connection.close();
			
			ILog.iclog(LogCategory.BatchInsert, "Done.");
		}catch(Exception e){
			ILog.iclog(LogCategory.BatchInsert, "Batch Insert exception :");
			ILog.iclog(LogCategory.BatchInsert, e);
			throw e;
		}
	}
	
}
