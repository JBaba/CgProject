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
    private int setUserById(long paymentKey) throws SQLException {
        ResultSet resultSet = getResultSet("select max(payment_key) as key from Fs_Payment");
        if(resultSet.next()) {
        	
        }else{
        	ILog.iclog("No records found with key :"+paymentKey);
        }
        return 0;
    }
	
	
	public static void main(String[] args) {

	}

}
