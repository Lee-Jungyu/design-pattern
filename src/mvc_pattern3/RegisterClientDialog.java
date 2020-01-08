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
import javax.swing.JTextField;

public class RegisterClientDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private JTextField nationalIdNoField;	//�ֹι�ȣ
	private JTextField idField;
	private JTextField passwordField;
	
	JButton okButton;
	JButton cancelButton;

	String name, nationalIdNo, id, password;
	
	private CommandController controller;
	private Command command;

	public RegisterClientDialog(CommandController c) {
		controller = c;
		
		init();
		run();
		setVisible(true);
	}

	private void init(){
		setBounds(100, 100, 266, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\uC131\uBA85");
			label.setBounds(12, 27, 57, 15);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
			lblNewLabel.setBounds(12, 75, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("ID");
			lblNewLabel_1.setBounds(12, 123, 57, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Password");
			lblNewLabel_2.setBounds(12, 170, 57, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			nameField = new JTextField();
			nameField.setBounds(90, 24, 116, 21);
			contentPanel.add(nameField);
			nameField.setColumns(10);
		}
		{
			nationalIdNoField = new JTextField();
			nationalIdNoField.setBounds(90, 72, 116, 21);
			contentPanel.add(nationalIdNoField);
			nationalIdNoField.setColumns(10);
		}
		{
			idField = new JTextField();
			idField.setColumns(10);
			idField.setBounds(90, 120, 116, 21);
			contentPanel.add(idField);
		}
		{
			passwordField = new JTextField();
			passwordField.setColumns(10);
			passwordField.setBounds(90, 167, 116, 21);
			contentPanel.add(passwordField);
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
			name = nameField.getText();
			nationalIdNo = nationalIdNoField.getText();
			id = idField.getText();
			password = passwordField.getText();
			
			command = new RegisterClientCommand(this);
			controller.setCommand(command);
			controller.doCommand();
			
			dispose();
		}
		
		if(cancelButton == e.getSource()){
			dispose();
		}
	}
	
	public String getName(){return name;}
	public String getNationalIdNo(){return nationalIdNo;}
	public String getId(){return id;}
	public String getPassword(){return password;}
}
