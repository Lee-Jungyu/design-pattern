package mvc_pattern3;

import java.io.Serializable;
import java.util.Date;

public class TradeRecord implements Serializable{
	private String tradeRecordCode;
	private Date tradeDate;
	private int type;	//withdraw(0)���� deposit(1)����
	private int balance;
	private int money;
	private String tradeRecord;
	private String accountCode;
	
	public TradeRecord(Account a, int money, int type, String record){
		tradeDate = new Date();
		this.setType(type);
		
		this.setMoney(money);
		balance = a.getBalance();
		setAccountCode(a.getAccountCode());
		tradeRecord = record;
	}

	public String getTradeRecordCode() {
		return tradeRecordCode;
	}

	public void setTradeRecordCode(String tradeRecordCode) {
		this.tradeRecordCode = tradeRecordCode;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getTradeRecord() {
		return tradeRecord;
	}

	public void setTradeRecord(String tradeRecord) {
		this.tradeRecord = tradeRecord;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	
}
