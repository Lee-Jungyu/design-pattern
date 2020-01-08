package mvc_pattern3;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Account implements Subject, Serializable{
	private String accountCode;
	private String clientId;
	private String accountHolderName;
	private String accountType;
	private int balance;
	private Date accountOpeningDate;
	private String accountPassword;
	private ArrayList<Observer> observers;
	
	public Account(Client client, String accountType, String accountPassword){
		observers = new ArrayList<Observer>();
		this.setClientId(client.getId());
		setAccountHolderName(client.getName());
		this.setAccountType(accountType);
		setBalance(0);
		setAccountOpeningDate(new Date());
		this.setAccountPassword(accountPassword);
		
	}
	
	
	public void deposit(int m){
		balance += m;
		notifyObservers();
	}
	public void withdraw(int m){
		setBalance(getBalance() - m);
		notifyObservers();
	}
	
	public void registerObservers(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}
	public void removeObservers(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++)
		{
			Observer observer = (Observer)observers.get(i);
			observer.update(this);
		}
	}


	public String getAccountCode() {
		return accountCode;
	}


	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}



	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public Date getAccountOpeningDate() {
		return accountOpeningDate;
	}


	public void setAccountOpeningDate(Date accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}


	public String getAccountPassword() {
		return accountPassword;
	}


	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
}
