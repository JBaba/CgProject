package multi.thread.entity.persiter;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import multi.thread.jdbc.Entity;
import multi.thread.logs.ILog;

/**
 * Get seq value
 * @author jbaba
 *
 */
public class SeqDao extends Entity{

	/**
	 * Get next seq value
	 * @param paymentKey
	 * @throws SQLException
	 */
    public int getMaxKey(String tableName) throws SQLException {
        ResultSet resultSet = getResultSet("select max(payment_key) as k from "+tableName);
        if(resultSet.next()) {
        	String value = resultSet.getString("k");
        	return Integer.parseInt(value);
        }else{
        	ILog.iclog("No records found.");
        }
        return 0;
    }
	
	
	public static void main(String[] args) {

	}

}
