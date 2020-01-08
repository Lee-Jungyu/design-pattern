package mvc_pattern3;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4792261565476046667L;
	private ArrayList<Client>clientList;
	   
	public ClientList() {
		clientList = new ArrayList<Client>();
		//파일에서 불러와야 함
	}
	
	public void insertClient(Client a) {
		clientList.add(a);
	}
	
	public void deleteclient(Client a) {
		clientList.remove(a);
	}
	
	public void deleteclient(String id) {
		for(int i = 0; i < clientList.size(); i++) {
			if(clientList.get(i).getId().equals(id))
				clientList.remove(i);
		}	
	}
	public Client findclientWithNationalIdNo(String nationalIdNo) {
		for(int i = 0; i < clientList.size(); i++) {
			if(clientList.get(i).getNationalIdNo().equals(nationalIdNo))
				return clientList.get(i);
		}
	      
		//not found
		return null;
	}
	
	public Client findclientWithId(String id){
		for(int i=0; i<clientList.size(); i++){
			if(clientList.get(i).getId().equals(id)){
				return clientList.get(i);
			}
		}
		return null;
	}
	
	public int getclientIndex(String id) {
		for(int i = 0; i < clientList.size(); i++) {
			if(clientList.get(i).getId().equals(id))
				return i;
		}	
		
		//not found
		return -1;
	}
	public int getSize(){
		return clientList.size();
	}
}