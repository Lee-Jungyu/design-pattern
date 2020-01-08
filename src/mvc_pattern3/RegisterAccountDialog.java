package mvc_pattern3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterAccountDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField passwordField;
	JComboBox accountTypeComboBox;
	
	JButton okButton;
	JButton cancelButton;
	
	String accountType;
	String password;
	
	private CommandController controller;
	private Command command;
	private Client client;

	public RegisterAccountDialog(CommandController controller, Client client) {
		this.client = client;
		this.controller = controller;
		init();
		run();
		setVisible(true);
	}
	
	private void init(){
		setBounds(100, 100, 285, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\uACC4\uC88C \uC885\uB958");
			label.setBounds(12, 47, 70, 15);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel.setBounds(12, 93, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			passwordField = new JTextField();
			passwordField.setBounds(96, 90, 116, 21);
			contentPanel.add(passwordField);
			passwordField.setColumns(10);
		}
		{
			accountTypeComboBox = new JComboBox();
			accountTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC77C\uBC18\uACC4\uC88C", "\uB9C8\uC774\uB108\uC2A4\uACC4\uC88C"}));
			accountTypeComboBox.setBounds(96, 44, 116, 21);
			contentPanel.add(accountTypeComboBox);
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
			accountType = accountTypeComboBox.getSelectedItem().toString();
			password = passwordField.getText();
			
			command = new RegisterAccountCommand(this,client);
			controller.setCommand(command);
			controller.doCommand();
				
			dispose();
		}
		
		if(cancelButton == e.getSource()){
			dispose();
		}
	}

	public String getAccountType(){
		return accountType;
	}
	public String getPassword(){return password;}

	
	
}
