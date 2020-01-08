package mvc_pattern3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PromotionDialog extends JDialog implements ActionListener{

   private final JPanel contentPanel = new JPanel();
   private JTextField textField;
   JButton okButton;
   JButton cancelButton;
   BankFrame view;
   
   CommandController controller;
   Command command;
   
   String promotion;

   /**
    * Create the dialog.
    */
   public PromotionDialog(CommandController c, BankFrame v) {
      controller = c;
      view = v;
      init();
      run();
      setVisible(true);
   }
   
   public void init() {
      setBounds(100, 100, 450, 191);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
      
      textField = new JTextField();
      textField.setBounds(33, 63, 368, 41);
      contentPanel.add(textField);
      textField.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("홍보 게시물 입력란");
      lblNewLabel.setBounds(33, 38, 134, 15);
      contentPanel.add(lblNewLabel);
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         {
            okButton = new JButton("OK");
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
         }
         {
            cancelButton = new JButton("Cancel");
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
         }
      }
   }
   
   public void run() {
      okButton.addActionListener(this);
      cancelButton.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO 자동 생성된 메소드 스텁
      if(okButton == e.getSource()){
         promotion = textField.getText();
         
         command = new PromotionCommand(this);
         controller.setCommand(command);
         controller.doCommand();
         
         view.textField.setText(promotion);
         dispose();
      }
      
      if(cancelButton == e.getSource()){
         dispose();
      }
   }
}