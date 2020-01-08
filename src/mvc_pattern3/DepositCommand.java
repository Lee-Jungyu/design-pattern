package mvc_pattern3;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class DepositCommand implements Command{
	Account account;
	DepositDialog dDlg;
	FileManager fm;
	
	public DepositCommand(DepositDialog d, Account a){
		dDlg = d;
		account = a;
		fm = new FileManager();
	}
	
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		int m = dDlg.getMoney();
		account.deposit(m);
		
		TradeRecord record = new TradeRecord(account, m, 1, account.getAccountHolderName());
		String tradeRecordCode = Integer.toString(DataSet.getInstance().tradeRecordList.cnt);
		
		DataSet.getInstance().tradeRecordList.cnt++;
		record.setTradeRecordCode(tradeRecordCode);
		DataSet.getInstance().tradeRecordList.insertTradingRecord(record);

		fm.saveTradeRecordFile(DataSet.getInstance().tradeRecordList);
		AccountList al = DataSet.getInstance().accountList;
		fm.saveAccountFile(al);
		
		System.out.println("입금 완료");
		//JOptionPane.showMessageDialog(null, "success");
	}

}
