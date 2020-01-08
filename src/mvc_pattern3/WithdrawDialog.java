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

public class WithdrawDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField moneyField;
	private JTextField passwordField;
	JButton okButton;
	JButton cancelButton;
	
	int money;
	String password;
	
	CommandController controller;
	Account account;


	public WithdrawDialog(CommandController c, Account a) {
		controller = c;
		account = a;
		init();
		run();
		setVisible(true);
	}
	
	public void init(){
		setBounds(100, 100, 317, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			moneyField = new JTextField();
			moneyField.setBounds(80, 57, 116, 21);
			contentPanel.add(moneyField);
			moneyField.setColumns(10);
		}
		{
			passwordField = new JTextField();
			passwordField.setBounds(80, 114, 116, 21);
			contentPanel.add(passwordField);
			passwordField.setColumns(10);
		}
		{
			JLabel label = new JLabel("\uAE08\uC561");
			label.setBounds(11, 60, 57, 15);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel.setBounds(11, 117, 57, 15);
			contentPanel.add(lblNewLabel);
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
			money = Integer.parseInt(moneyField.getText());
			password = passwordField.getText();
			
			WithdrawCommand w = new WithdrawCommand(this, account);
			controller.setCommand(w);
			controller.doCommand();
			
			dispose();
		}
		
		if(cancelButton == e.getSource()){
			dispose();
		}
	}
	
	public String getPassword(){return password;}
	public int getMoney(){return money;}

}
