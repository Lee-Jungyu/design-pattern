package mvc_pattern3;

import javax.swing.JOptionPane;

public class BalanceInquiringCommand implements Command{
	Account account;
	
	public BalanceInquiringCommand(Account a){
		account = a;
	}
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Balance : " + DataSet.getInstance().accountList.findAccountWithAccountCode(account.getAccountCode()).getBalance());
	}

}
