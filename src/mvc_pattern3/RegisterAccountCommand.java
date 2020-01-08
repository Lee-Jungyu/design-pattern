package mvc_pattern3;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class RegisterAccountCommand implements Command{
	RegisterAccountDialog raDlg;
	FileManager fm;
	Client client;
	
	public RegisterAccountCommand(RegisterAccountDialog raDlg, Client c){
		this.raDlg = raDlg;
		client = c;
		fm = new FileManager();
	}
	
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		Account a = new Account(client, raDlg.getAccountType(), raDlg.getPassword());
		String accountCode = Integer.toString(DataSet.getInstance().accountList.finalNo);
		a.setAccountCode(accountCode);

		DataSet.getInstance().accountList.insertAccount(a);
		DataSet.getInstance().accountList.finalNo++;
		fm.saveAccountFile(DataSet.getInstance().accountList);
		JOptionPane.showMessageDialog(null, "Account is registered Succesfully");
		System.out.println("계좌 등록 완료");
		client.notifyObservers();
	}

}
