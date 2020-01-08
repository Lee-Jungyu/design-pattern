package mvc_pattern3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AccountFrame extends JFrame implements ActionListener, Observer{

	private JPanel contentPane;
	private JButton accountSelectingButton;
	private JButton accountOpeningButton;
	private JList accountListView;
	private JScrollPane scrollPane;
	
	CommandController controller;
	Client client;
	AccountList accountList;
	/**
	 * Launch the application.
	 */
	public AccountFrame(CommandController controller, Client client) {
		this.client = client;
		this.controller = controller;
		accountList = DataSet.getInstance().accountList.findAccountWithId(client.getId());
		client.registerObservers(this);
		
		init();
		run();
		setVisible(true);
		
		//client.registerObservers(this);
	}
	/**
	 * Create the frame.
	 */
	
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		accountListView = new JList( accountList.getAccountCodeList());
		accountListView.setBounds(49, 73, 335, 103);
		contentPane.add(accountListView);
		
		scrollPane = new JScrollPane(accountListView);
		scrollPane.setBounds(49, 73, 335, 103);
		contentPane.add(scrollPane);
		//contentPane.add(new JScrollPane(accountListView));
		
		
		accountSelectingButton = new JButton("\uACC4\uC88C \uC120\uD0DD");
		accountSelectingButton.setBounds(210, 191, 97, 23);
		contentPane.add(accountSelectingButton);
		
		accountOpeningButton = new JButton("\uACC4\uC88C \uB4F1\uB85D");
		accountOpeningButton.setBounds(80, 191, 97, 23);
		contentPane.add(accountOpeningButton);
		
		JLabel lblNewLabel = new JLabel("\uC804 \uACC4\uC88C \uC870\uD68C");
		lblNewLabel.setBounds(14, 12, 97, 34);
		contentPane.add(lblNewLabel);
		
	}
	
	private void run(){
		accountSelectingButton.addActionListener(this);
		accountOpeningButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(accountSelectingButton == e.getSource()){	//���� ���� ��ư Ŭ����
			
			String accountCode = accountListView.getSelectedValue().toString();
			Account account = DataSet.getInstance().accountList.findAccountWithAccountCode(accountCode);
			
			BankFrame frame = new BankFrame(controller, account);
			dispose();
		}
		
		if(accountOpeningButton == e.getSource()){	//���� ���� ��ư Ŭ����
			RegisterAccountDialog raDlg = new RegisterAccountDialog(controller, client);
		}
	}
	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		client = (Client)o;
		
		accountList = DataSet.getInstance().accountList.findAccountWithId(client.getId());
		
		accountListView.setListData(accountList.getAccountCodeList());
		//System.out.println(accountList.getSize());
		//listView�ٽ� �׸���
	}
}
