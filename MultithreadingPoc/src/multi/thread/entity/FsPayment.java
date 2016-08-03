package multi.thread.entity;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import multi.thread.jdbc.Entity;

/**
 * FsPayment entity for FS_PAYMENT table
 * @author jbaba
 *
 */
public class FsPayment extends Entity {
    private BigInteger paymentKey;
    private String progCd;
    private String paymentBegDt;
    private String paymentEndDt;
    private String createDt;
    private String userId;
    private long payAmt;
    private String processSw;
    private String caseNum;
    private String edgNum;

   

    public FsPayment(BigInteger paymentKey, String progCd, String paymentBegDt, String paymentEndDt, String createDt,
			String userId, long payAmt, String processSw, String caseNum, String edgNum) {
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

	public FsPayment(BigInteger paymentKey) throws SQLException {
        super();
        this.paymentKey = paymentKey;
        setUserById(paymentKey);
    }

    private void setUserById(BigInteger paymentKey) throws SQLException {
        ResultSet resultSet = getResultSet("SELECT * FROM FS_PAYMENT WHERE payment_Key = " + paymentKey);
        if(resultSet.next()) {
        	paymentKey = new BigInteger(resultSet.getString("payment_Key"));
        	progCd = resultSet.getString("prog_cd");
        	paymentBegDt = resultSet.getString("payment_beg_dt");
        	paymentEndDt = resultSet.getString("payment_end_dt");
            createDt = resultSet.getString("create_dt");
            userId = resultSet.getString("user_id");
            payAmt = Long.parseLong(resultSet.getString("pay_amt"));
            processSw = resultSet.getString("process_sw");
            caseNum = resultSet.getString("case_num");
            edgNum = resultSet.getString("edg_num");
        }
    }

	@Override
	public String toString() {
		return "FsPayment [paymentKey=" + paymentKey + ", progCd=" + progCd + ", paymentBegDt=" + paymentBegDt
				+ ", paymentEndDt=" + paymentEndDt + ", createDt=" + createDt + ", userId=" + userId + ", payAmt="
				+ payAmt + ", processSw=" + processSw + ", caseNum=" + caseNum + ", edgNum=" + edgNum + "]";
	}

}
