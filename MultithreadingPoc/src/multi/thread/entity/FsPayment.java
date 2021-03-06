package multi.thread.entity;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import multi.thread.jdbc.Entity;
import multi.thread.logs.ILog;
import multi.thread.util.NSeq;

/**
 * FsPayment entity for FS_PAYMENT table
 * @author jbaba
 *
 */
public class FsPayment extends Entity implements IEntity{
    private BigInteger paymentKey;
    private String progCd;
    private String paymentBegDt;
    private String paymentEndDt;
    private String createDt;
    private String userId;
    private double payAmt;
    private String processSw;
    private String caseNum;
    private String edgNum;

    public FsPayment() {
	}

    public FsPayment(BigInteger paymentKey, String progCd, String paymentBegDt, String paymentEndDt, String createDt,
			String userId, double payAmt, String processSw, String caseNum, String edgNum) {
		super();
		this.paymentKey = paymentKey;
		this.progCd = progCd;
		this.paymentBegDt = paymentBegDt;
		this.paymentEndDt = paymentEndDt;
		this.createDt = createDt;
		this.userId = userId;
		this.payAmt = payAmt;
		this.processSw = processSw;
		this.caseNum = caseNum;
		this.edgNum = edgNum;
	}

	public FsPayment(long paymentKey) throws SQLException {
        super();
        this.paymentKey = new BigInteger(paymentKey+"");
        setUserById(paymentKey);
    }

	/**
	 * Get record for given payment key
	 * @param paymentKey
	 * @throws SQLException
	 */
    private void setUserById(long paymentKey) throws SQLException {
        ResultSet resultSet = getResultSet("SELECT * FROM Fs_Payment WHERE payment_Key = " + paymentKey);
        if(resultSet.next()) {
        	this.paymentKey = new BigInteger(resultSet.getString("payment_Key"));
        	progCd = resultSet.getString("prog_cd");
        	paymentBegDt = resultSet.getString("payment_beg_dt");
        	paymentEndDt = resultSet.getString("payment_end_dt");
            createDt = resultSet.getString("create_dt");
            userId = resultSet.getString("user_id");
            payAmt = Double.parseDouble(resultSet.getString("pay_amt"));
            processSw = resultSet.getString("process_sw");
            caseNum = resultSet.getString("case_num");
            edgNum = resultSet.getString("edg_num");
        }else{
        	ILog.iclog("No records found with key :"+paymentKey);
        }
    }
    
    /**
     * Return sql insert query
     * @return
     */
    public String getInsert(){
        String sql = "INSERT INTO Fs_Payment VALUES ("+NSeq.nextFs();
        
        if(progCd != null)
        	sql+=",'"+progCd+"',";
        else
        	sql+=",NULL,";
        
        if(paymentBegDt != null)
        	sql+="'"+paymentBegDt+"',";
        else
        	sql+="NULL,";
        
        if(paymentEndDt != null)
        	sql+="'"+paymentEndDt+"',";
        else
        	sql+="NULL,";
        
        if(createDt != null)
        	sql+="'"+createDt+"',";
        else
        	sql+="NULL,";
        
        if(userId != null)
        	sql+="'"+userId+"',";
        else
        	sql+="NULL,";
        
       	sql+="'"+payAmt+"',";
        
       	if(processSw != null)
        	sql+="'"+processSw+"',";
        else
        	sql+="NULL,";
       	
       	if(caseNum != null)
        	sql+="'"+caseNum+"',";
        else
        	sql+="NULL,";
       	
       	if(edgNum != null)
        	sql+="'"+edgNum+"')";
        else
        	sql+="NULL)";
       	
       	return sql;
    }

	@Override
	public String toString() {
		return "FsPayment [paymentKey=" + paymentKey + ", progCd=" + progCd + ", paymentBegDt=" + paymentBegDt
				+ ", paymentEndDt=" + paymentEndDt + ", createDt=" + createDt + ", userId=" + userId + ", payAmt="
				+ payAmt + ", processSw=" + processSw + ", caseNum=" + caseNum + ", edgNum=" + edgNum + "]";
	}
	
	public static void main(String[] args){
		try{
			FsPayment fs = new FsPayment(1);
			ILog.iclog(fs.toString());
		}catch(Exception e){
			ILog.iclog(e);
		}
	}

	public BigInteger getPaymentKey() {
		return paymentKey;
	}
	
	public synchronized String getPaymentKeyForInsert() {
		return NSeq.nextFs()+"";
	}

	public void setPaymentKey(BigInteger paymentKey) {
		this.paymentKey = paymentKey;
	}

	public String getProgCd() {
		return progCd;
	}

	public void setProgCd(String progCd) {
		this.progCd = progCd;
	}

	public String getPaymentBegDt() {
		return paymentBegDt;
	}

	public void setPaymentBegDt(String paymentBegDt) {
		this.paymentBegDt = paymentBegDt;
	}

	public String getPaymentEndDt() {
		return paymentEndDt;
	}

	public void setPaymentEndDt(String paymentEndDt) {
		this.paymentEndDt = paymentEndDt;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(double payAmt) {
		this.payAmt = payAmt;
	}

	public String getProcessSw() {
		return processSw;
	}

	public void setProcessSw(String processSw) {
		this.processSw = processSw;
	}

	public String getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}

	public String getEdgNum() {
		return edgNum;
	}

	public void setEdgNum(String edgNum) {
		this.edgNum = edgNum;
	}

	
}
