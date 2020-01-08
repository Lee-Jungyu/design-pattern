package mvc_pattern3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BankFrame extends JFrame implements ActionListener, Observer{

   private JPanel contentPane;
   JTextField textField;
   JButton depositButton;
   JButton withdrawButton;
   JButton transferButton;
   JButton balanceButton;
   JButton recordsButton;
   JButton promotionButton;
   
   CommandController controller;
   Account account;

   public BankFrame(CommandController c, Account a) {
      controller = c;
      account = a;
      FileManager fm = new FileManager();
      String promotion = fm.loadPromotionFile();
      if(promotion.equals(null)) {
         promotion = "";
      }
      init();

      textField.setText(promotion);
      run();
      setVisible(true);
      account.registerObservers(this);
   }
   
   private void init(){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      depositButton = new JButton("\uC785\uAE08");
      depositButton.setBounds(26, 26, 97, 23);
      contentPane.add(depositButton);
      
      withdrawButton = new JButton("\uCD9C\uAE08");
      withdrawButton.setBounds(26, 73, 97, 23);
      contentPane.add(withdrawButton);
      
      transferButton = new JButton("\uACC4\uC88C\uC774\uCCB4");
      transferButton.setBounds(26, 125, 97, 23);
      contentPane.add(transferButton);
      
      balanceButton = new JButton("\uC794\uACE0 \uC870\uD68C");
      balanceButton.setBounds(248, 26, 135, 23);
      contentPane.add(balanceButton);
      
      recordsButton = new JButton("\uAC70\uB798\uB0B4\uC5ED \uC870\uD68C");
      recordsButton.setBounds(248, 73, 135, 23);
      contentPane.add(recordsButton);

      promotionButton = new JButton("새 상품 홍보");
      promotionButton.setBounds(248, 125, 135, 23);
      contentPane.add(promotionButton);
      
      textField = new JTextField();
      textField.setBackground(Color.WHITE);
      textField.setEditable(false);
      textField.setBounds(26, 204, 357, 47);
      contentPane.add(textField);
      textField.setColumns(10);
      
      JLabel label = new JLabel("*\uACF5\uC9C0\uC0AC\uD56D*");
      label.setFont(new Font("210 �ǹ���û�� R", Font.PLAIN, 14));
      label.setBounds(26, 179, 79, 15);
      contentPane.add(label);
      
   }
   
   private void run(){
      depositButton.addActionListener(this);
      withdrawButton.addActionListener(this);
      transferButton.addActionListener(this);
      balanceButton.addActionListener(this);
      recordsButton.addActionListener(this);
      promotionButton.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e){
      if(depositButton == e.getSource()){
         DepositDialog d = new DepositDialog(controller, account);
      }
      
      if(withdrawButton == e.getSource()){   
         WithdrawDialog w = new WithdrawDialog(controller, account);
         
      }
      
      if(transferButton == e.getSource()){
         AccountTransferDialog a = new AccountTransferDialog(controller, account);
         
      }
      
      if(balanceButton == e.getSource()){
         BalanceInquiringCommand b = new BalanceInquiringCommand(account);
         controller.setCommand(b);
         controller.doCommand();
      }
      
      if(recordsButton == e.getSource()){
         TradingRecordDialog tDlg = new TradingRecordDialog(controller, account);
      }
      
      if(promotionButton == e.getSource()) {
         Client c = DataSet.getInstance().clientList.findclientWithId(account.getClientId());
         if(c.getClientType().equals("admin")) {
            PromotionDialog pDlg = new PromotionDialog(controller, this);
            
            FileManager fm = new FileManager();
            String promotion = fm.loadPromotionFile();
            textField.setText(promotion);
         }
         else {
            JOptionPane.showMessageDialog(null, "관리자만 사용할 수 있습니다");
         }
      }
      
   }

   @Override
   public void update(Object o) {
      // TODO Auto-generated method stub
      account = (Account)o;
   }
}