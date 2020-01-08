package mvc_pattern3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JButton loginButton;
	JButton registerButton;
	
	CommandController controller;
	
	public String id;
	public String pw;

	/**
	 * Launch the application.
	 */	
	public LoginFrame(CommandController c){
		controller = c;
		
		init();
		run();
		setVisible(true);
	}
	
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(162, 22, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 61, 116, 21);
		contentPane.add(textField_1);
		
		loginButton = new JButton("\uB85C\uADF8\uC778");
		loginButton.setBounds(174, 115, 97, 23);
		contentPane.add(loginButton);
		
		registerButton = new JButton("\uACE0\uAC1D \uB4F1\uB85D");
		registerButton.setBounds(174, 155, 97, 23);
		contentPane.add(registerButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(106, 25, 57, 15);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(93, 64, 57, 15);
		contentPane.add(lblPassword);
	}
	
	private void run(){
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
	}
	
	/**
	 * Create the frame.
	 */
	public void actionPerformed(ActionEvent e){
		if(loginButton == e.getSource()){	
			id = textField.getText();
			pw = textField_1.getText();
			
			if(DataSet.getInstance().clientList.findclientWithId(id)!=null) {
				Client c = DataSet.getInstance().clientList.findclientWithId(id);
				if(c.getPassword().equals(pw)){
					AccountFrame frame = new AccountFrame(controller, c);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong password.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "ID is wrong.");
			}
		}
		
		if(registerButton == e.getSource()){
			RegisterClientDialog rcDlg = new RegisterClientDialog(controller);
		}
	}

}
