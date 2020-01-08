package mvc_pattern2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorView extends JFrame implements Observer {
	
	private JPanel contentPane;
	public JTextField operator1;
	public JTextField operator2;
	public JTextField answer;
	JButton plusBtn;
	JButton minusBtn;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CalculatorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		operator1 = new JTextField();
		operator1.setBounds(32, 45, 116, 21);
		contentPane.add(operator1);
		operator1.setColumns(10);
		
		operator2 = new JTextField();
		operator2.setBounds(160, 45, 116, 21);
		contentPane.add(operator2);
		operator2.setColumns(10);
		
		plusBtn = new JButton("+");
		plusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		plusBtn.setBounds(42, 76, 97, 23);
		contentPane.add(plusBtn);
		
		minusBtn = new JButton("-");
		minusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		minusBtn.setBounds(170, 76, 97, 23);
		contentPane.add(minusBtn);
		
		answer = new JTextField();
		answer.setBounds(96, 158, 116, 21);
		contentPane.add(answer);
		answer.setColumns(10);
	}
	
	public void setCalcSolution(int result) {
		answer.setText(Integer.toString(result));
	}
	
	@Override
	public void update(int data) {
		// TODO 자동 생성된 메소드 스텁
		setCalcSolution(data);
	}

	public void setCalculatorListener(ActionListener listener) {
		// TODO 자동 생성된 메소드 스텁
		plusBtn.addActionListener(listener);
		minusBtn.addActionListener(listener);
	}
}

