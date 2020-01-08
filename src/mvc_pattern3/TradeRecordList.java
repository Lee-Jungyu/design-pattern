package mvc_pattern3;

import java.io.Serializable;
import java.util.ArrayList;

public class TradeRecordList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5381462823176866571L;
	private ArrayList<TradeRecord> tradeRecordList;
	int cnt=0;
	public TradeRecordList() {
		tradeRecordList = new ArrayList<TradeRecord>();
	}
	
	public void insertTradingRecord(TradeRecord a) {
		tradeRecordList.add(a);
	}
	
	public void deletetradingRecord(TradeRecord a) {
		tradeRecordList.remove(a);
	}
	
	public void deletetradingRecord(String tradeRecordCode) {
		for(int i = 0; i < tradeRecordList.size(); i++) {
			if(tradeRecordList.get(i).getTradeRecordCode().equals(tradeRecordCode))
				tradeRecordList.remove(i);
		}
	}
	public TradeRecord findtradingRecord(String tradeRecordCode) {
		for(int i = 0; i < tradeRecordList.size(); i++) {
			if(tradeRecordList.get(i).getTradeRecordCode().equals(tradeRecordCode))
				return tradeRecordList.get(i);
		}
		
		//not found
		return null;
	}
	
	public TradeRecordList findTradingRecordWithAccountCode(String accountCode){
		TradeRecordList list = new TradeRecordList();
		for(int i=0; i<tradeRecordList.size(); i++){
			if(tradeRecordList.get(i).getAccountCode().equals(accountCode))
				list.insertTradingRecord(tradeRecordList.get(i));
		}
		return list;
	}
	
/*	public TradeRecordList findTradingRecordWithType(String type){
		switch(type){
		case "����":
			for(int i=0; i<tradeRecordList.size(); i++){
				
			}
			break;
		case "1����":
			break;
		case "3����":
			break;
		}
	}*/
		
	public int gettradingRecordIndex(String tradeRecordCode) {
		for(int i = 0; i < tradeRecordList.size(); i++) {
			if(tradeRecordList.get(i).getTradeRecordCode().equals(tradeRecordCode))
				return i;
		}
		
		//not found
		return -1;
	}
	
	public int getSize(){
		return tradeRecordList.size();
	}
	public TradeRecord findTradingRecordWithIndex(int index){
		return tradeRecordList.get(index);
	}
	
}
