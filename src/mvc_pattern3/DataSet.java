package mvc_pattern3;


public class DataSet {
	public ClientList clientList;
	public AccountList accountList;
	public TradeRecordList tradeRecordList;
	
	private volatile static DataSet instance = null;
	
	//�̱���
	private DataSet() {
		clientList = new ClientList();
		accountList = new AccountList();
		tradeRecordList = new TradeRecordList();
		
	}
	
	public static DataSet getInstance() {
		if (instance != null) { 
			return instance;
	  	} else {
	 	  	synchronized (DataSet.class) { 
				if (instance == null) {	
			  		instance = new DataSet();
			  		FileManager fm = new FileManager();
			  		fm.loadClientFile();
			  		fm.loadAccountFile();
			  		fm.loadTradeRecordFile();
				}
		  	}
			return instance;
		}
	}
}
