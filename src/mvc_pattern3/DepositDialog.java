package mvc_pattern3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	JButton okButton;
	JButton cancelButton;
	int money;
	
	CommandController controller;
	Account account;

	public DepositDialog(CommandController c, Account a) {
		controller = c;
		account = a;
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
			textField = new JTextField();
			textField.setBounds(156, 66, 116, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("\uAE08\uC561");
			lblNewLabel.setBounds(80, 69, 57, 15);
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
			money = Integer.parseInt(textField.getText());
			
			DepositCommand d = new DepositCommand(this, account);
			controller.setCommand(d);
			controller.doCommand();
			
			dispose();
		}
		if(cancelButton == e.getSource()){
			dispose();
			JOptionPane.showMessageDialog(null, "Deposit is canceled");
		}
	}
	
	public int getMoney(){return money;}

}
