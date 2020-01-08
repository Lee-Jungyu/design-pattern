package mvc_pattern3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class AccountList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -827298511121715802L;
	private ArrayList<Account>accountList;
	int finalNo = 0;
	public AccountList() {
		accountList = new ArrayList<Account>();
	}
	
	public void insertAccount(Account a) {
		accountList.add(a);
	}
	
	public void deleteAccount(Account a) {
		accountList.remove(a);
	}
	
	public void deleteAccount(String accountCode) {
		for(int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getAccountCode().equals(accountCode))
				accountList.remove(i);
		}
	}
	
	public Account findAccountWithAccountCode(String accountCode) {
		for(int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getAccountCode().equals(accountCode))
				return accountList.get(i);
		}
		
		//not found
		return null;
	}
	
	public Account findAccountWithIndex(int i) {
		return accountList.get(i);
	}
	
	public AccountList findAccountWithId(String Id){
		AccountList list = new AccountList();
		for(int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getClientId().equals(Id))
				list.insertAccount(accountList.get(i));
		}
		
		return list;
	}
	
		
	public int getAccountIndex(String accountCode) {
		for(int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getAccountCode().equals(accountCode))
				return i;
		}
		
		//not found
		return -1;
	}
	
	public Vector<String> getAccountCodeList() {
		Vector<String> list = new Vector();
		
		for(int i = 0; i < accountList.size(); i++) {
			list.add(accountList.get(i).getAccountCode());
		}
		return list;
	}
	
	
	public int getSize() {
		return accountList.size();
	}
	
}
