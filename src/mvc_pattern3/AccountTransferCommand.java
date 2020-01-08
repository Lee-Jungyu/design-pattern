package mvc_pattern3;

import javax.swing.JOptionPane;

public class AccountTransferCommand implements Command{
	Account srcAccount;
	Account dstAccount;
	AccountTransferDialog atDlg;
	FileManager fm;
	
	public AccountTransferCommand(AccountTransferDialog c, Account a){
		srcAccount = a;
		atDlg = c;
		fm = new FileManager();
	}
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		String password = atDlg.getPassword();
		int m = atDlg.getMoney();
		dstAccount = DataSet.getInstance().accountList.findAccountWithAccountCode(atDlg.getAccount());
		System.out.println(srcAccount.getAccountPassword());
		if(srcAccount.getAccountPassword().equals(password)){
			if(srcAccount.getBalance() >= m){
				DataSet.getInstance().accountList.findAccountWithAccountCode(srcAccount.getAccountCode()).withdraw(m);
				fm.saveAccountFile(DataSet.getInstance().accountList);
				TradeRecord record = new TradeRecord(srcAccount, m, 0, dstAccount.getAccountHolderName());
				record.setTradeRecordCode(Integer.toString(DataSet.getInstance().tradeRecordList.cnt++));
				DataSet.getInstance().tradeRecordList.insertTradingRecord(record);
				fm.saveTradeRecordFile(DataSet.getInstance().tradeRecordList);
				
				DataSet.getInstance().accountList.findAccountWithAccountCode(dstAccount.getAccountCode()).deposit(m);
				fm.saveAccountFile(DataSet.getInstance().accountList);
				record = new TradeRecord(dstAccount, m, 1, srcAccount.getAccountHolderName());
				record.setTradeRecordCode(Integer.toString(DataSet.getInstance().tradeRecordList.cnt++));
				DataSet.getInstance().tradeRecordList.insertTradingRecord(record);
				fm.saveTradeRecordFile(DataSet.getInstance().tradeRecordList);
				
			}
			else{
				//�ܾ׺��� �޽��� �ڽ�
				JOptionPane.showMessageDialog(null, "not enough balance!!");
			}
		}
		else{
			//��й�ȣ ���� �޽��� �ڽ�
			JOptionPane.showMessageDialog(null, "wrong password!!");
		}
	}

}
