package mvc_pattern3;

import javax.swing.JOptionPane;

public class WithdrawCommand implements Command{
	Account account;
	WithdrawDialog wDlg;
	FileManager fm;
	
	public WithdrawCommand(WithdrawDialog w, Account a){
		wDlg = w;
		account = a;
		fm = new FileManager();
	}
	
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		int m = wDlg.getMoney();
		if(account.getAccountPassword().equals(wDlg.getPassword())){
			DataSet.getInstance().accountList.findAccountWithAccountCode(account.getAccountCode()).withdraw(m);
			fm.saveAccountFile(DataSet.getInstance().accountList);
			TradeRecord record = new TradeRecord(account, m, 0, account.getAccountHolderName());
			record.setTradeRecordCode(Integer.toString(DataSet.getInstance().tradeRecordList.cnt++));
			DataSet.getInstance().tradeRecordList.insertTradingRecord(record);
			fm.saveTradeRecordFile(DataSet.getInstance().tradeRecordList);
		}
		else{
			JOptionPane.showMessageDialog(null, "wrong password!");
		}
	}

}
