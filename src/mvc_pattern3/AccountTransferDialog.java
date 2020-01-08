package mvc_pattern3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AccountTransferDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField accountField;
	private JTextField moneyField;
	private JTextField passwordField;
	
	JButton okButton;
	JButton cancelButton;
	
	String accountCode;
	String password;
	int money;
	
	CommandController controller;
	Account account;

	public AccountTransferDialog(CommandController c, Account a) {
		controller = c;
		this.account = a;
		init();
		run();
		setVisible(true);
	}
	
	private void init(){
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			accountField = new JTextField();
			accountField.setBounds(155, 54, 116, 21);
			contentPanel.add(accountField);
			accountField.setColumns(10);
		}
		{
			moneyField = new JTextField();
			moneyField.setColumns(10);
			moneyField.setBounds(155, 101, 116, 21);
			contentPanel.add(moneyField);
		}
		{
			passwordField = new JTextField();
			passwordField.setColumns(10);
			passwordField.setBounds(155, 148, 116, 21);
			contentPanel.add(passwordField);
		}
		{
			JLabel label = new JLabel("\uC774\uCCB4\uD560 \uACC4\uC88C");
			label.setBounds(31, 58, 86, 15);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("\uAE08\uC561");
			lblNewLabel.setBounds(60, 104, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel_1.setBounds(49, 151, 57, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("\uD655\uC778");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void run(){
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(okButton == e.getSource()){			
			accountCode = accountField.getText();
			password = passwordField.getText();
			money = Integer.parseInt(moneyField.getText());
			
			AccountTransferCommand ac = new AccountTransferCommand(this, account);
			controller.setCommand(ac);
			controller.doCommand();
			
			dispose();
		}
		
		if(cancelButton == e.getSource()){
			dispose();
			JOptionPane.showMessageDialog(null, "AccountTransfer is canceled");
		}
	}
	
	public String getAccount(){return accountCode;}
	public String getPassword(){return password;}
	public int getMoney(){return money;}

}
