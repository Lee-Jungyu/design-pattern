package mvc_pattern3;

import javax.swing.JOptionPane;

public class RegisterClientCommand implements Command{
	private FileManager fm = new FileManager();
	RegisterClientDialog rcDlg;
	
	public RegisterClientCommand(RegisterClientDialog rcDlg) {
		this.rcDlg = rcDlg;
	}
	
	public void excute(){
		String name = rcDlg.getName();
		String nationalIdNo = rcDlg.getNationalIdNo();
		String id = rcDlg.getId();
		String password = rcDlg.getPassword();
		
		if(DataSet.getInstance().clientList.findclientWithId(id) != null) {
			JOptionPane.showMessageDialog(null, "you can't use this ID!");
			return;
		}
		
		if(DataSet.getInstance().clientList.findclientWithNationalIdNo(nationalIdNo) != null) {
			JOptionPane.showMessageDialog(null, "you can't use this nationalNumber!");
			return;
		}
		
		Client client = new Client(name, nationalIdNo, id, password);
		
		DataSet.getInstance().clientList.insertClient(client);
		fm.saveClientFile(DataSet.getInstance().clientList);
		JOptionPane.showMessageDialog(null, "ID is registered Succesfully");
		System.out.println("계정 등록 완료");
	}
}
