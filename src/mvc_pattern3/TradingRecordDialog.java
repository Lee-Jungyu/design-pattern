package mvc_pattern3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TradingRecordDialog extends JDialog implements ActionListener, ItemListener{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scrollPane;
	
	JButton okButton;
	
	JRadioButton dayRadioButton;
	JRadioButton oneMRadioButton;
	JRadioButton threeMRadioButton;
	
	Account account;
	CommandController controller;
	TradeRecordList list;

	public TradingRecordDialog(CommandController c, Account a) {
		account = a;
		controller = c;
		init();
		run();
		setVisible(true);
		list = DataSet.getInstance().tradeRecordList.findTradingRecordWithAccountCode(account.getAccountCode());
	}
	
	private void init(){
		setBounds(100, 100, 502, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"No.", "Date", "Type", "Record", "Money", "Balance"
			}
		));
		table.setBounds(23, 56, 435, 196);
		table.setFillsViewportHeight(true); 
		contentPanel.add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(23, 56, 435, 196);
		contentPanel.add(scrollPane);
		
		
		dayRadioButton = new JRadioButton("\uB2F9\uC77C");
		dayRadioButton.setBounds(55, 18, 121, 23);
		contentPanel.add(dayRadioButton);
		
		oneMRadioButton = new JRadioButton("1개월");
		oneMRadioButton.setBounds(182, 18, 121, 23);
		contentPanel.add(oneMRadioButton);
		
		threeMRadioButton = new JRadioButton("3\uAC1C\uC6D4");
		threeMRadioButton.setBounds(309, 18, 121, 23);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(dayRadioButton);
		btnGroup.add(oneMRadioButton);
		btnGroup.add(threeMRadioButton);
		
		contentPanel.add(threeMRadioButton);
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
		}
	}
	
	private void run(){
		okButton.addActionListener(this);
		dayRadioButton.addItemListener(this);
		oneMRadioButton.addItemListener(this);
		threeMRadioButton.addItemListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(okButton == e.getSource()){
			dispose();
		}
	}
	
	public void itemStateChanged(ItemEvent e)
    {
           AbstractButton sel = (AbstractButton)e.getItemSelectable();
           if(e.getStateChange() == ItemEvent.SELECTED)
           {
                  
                  if ( sel == oneMRadioButton )
                  {        
                	  tableSet(1);
                	  table.updateUI();
                  }
                  else if(sel == threeMRadioButton){
                	  tableSet(3);
                	  table.updateUI();
                  }
                  else if ( sel == dayRadioButton )
                  {          
                  	tableSet(0);
                  	table.updateUI();
                  }
           }
    }
	
	public void tableSet(int type){
		SimpleDateFormat f = new SimpleDateFormat("yy-MM-dd");
		Date today = new Date ( );
		
		DefaultTableModel m = (DefaultTableModel)table.getModel();
		int check=0;
		m.setRowCount(0);
		int cnt =1;
		for(int i=0; i<list.getSize(); i++){
			TradeRecord tmp = list.findTradingRecordWithIndex(i);
			if(type == 0)
				check = tmp.getTradeDate().getDate() - today.getDate();
			else if(type == 1)
				check =  today.getMonth() - tmp.getTradeDate().getMonth() ;
			else if(type == 3)
				check =  today.getMonth() - tmp.getTradeDate().getMonth();
			if(check <= type){
				if(tmp.getType() == 0){
					Object[] row = {cnt++, f.format(tmp.getTradeDate()),
							"withdraw", tmp.getTradeRecord(), tmp.getMoney(), tmp.getBalance()};
					m.addRow(row);
				}
				else if(tmp.getType() == 1){
					Object[] row = {cnt++, f.format(tmp.getTradeDate()),
							"deposit", tmp.getTradeRecord(), tmp.getMoney(), tmp.getBalance()};
					m.addRow(row);
				}
				
			}
		}
	}
	
	
}
