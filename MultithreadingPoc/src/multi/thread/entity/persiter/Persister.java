package multi.thread.entity.persiter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import multi.thread.entity.FsPayment;
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
		prepareinsert();
	}
	
	/**
	 * Insert all using batch commit
	 * @throws Exception
	 */
	public void stinsert() throws Exception{
		
		try{
			ILog.iclog(LogCategory.BatchInsert, "Batch Insert started...");
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			
			ILog.iclog(LogCategory.BatchInsert, "Size:"+sqlInsert.size());
			for (String query : sqlInsert) {
				//ILog.iclog(LogCategory.BatchInsert, query);
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
	
	/**
	 * Insert all using batch commit
	 * @throws Exception
	 */
	public void prepareinsert() throws Exception{
		
		try{
			ILog.iclog(LogCategory.BatchInsert, "Batch Insert started...");
			String sql = "INSERT INTO Fs_Payment VALUES (?,?,?,?,?,?,?,?,?,?)";
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ILog.iclog(LogCategory.BatchInsert, "Size:"+sqlInsert.size());
			for (IEntity en : entity) {
				FsPayment fs = (FsPayment) en;
				statement.setString(1, fs.getPaymentKeyForInsert()+"");
				statement.setString(2, fs.getProgCd());
				statement.setString(3, fs.getPaymentBegDt());
				statement.setString(4, fs.getPaymentEndDt());
				statement.setString(5, fs.getCreateDt());
				statement.setString(6, fs.getUserId());
				statement.setString(7, fs.getPayAmt()+"");
				statement.setString(8, fs.getProcessSw());
				statement.setString(9, fs.getCaseNum());
				statement.setString(10,fs.getEdgNum());
				statement.addBatch();
			}
			
			ILog.iclog(LogCategory.BatchInsert, "execute..");
			statement.execute();
			statement.close();
			connection.close();
			
			ILog.iclog(LogCategory.BatchInsert, "Done.");
		}catch(Exception e){
			ILog.iclog(LogCategory.BatchInsert, "Batch Insert exception :");
			ILog.iclog(LogCategory.BatchInsert, e);
			throw e;
		}
	}
	
	public static void main(String[] s){
		FsPayment fs = new FsPayment();
		fs.setCaseNum("1");
		fs.setProgCd("FS");
		fs.setPayAmt(10);
		fs.setProcessSw("N");
		
		Persister p =new Persister();
		p.add(fs);
		try{
			p.insert();
		}catch(Exception e){
			ILog.iclog(e);
		}
	}
	
}
