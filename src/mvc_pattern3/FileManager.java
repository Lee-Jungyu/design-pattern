package mvc_pattern3;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileManager implements Serializable{

   void saveClientFile(ClientList c) {
      
      OutputStream out = null;
      BufferedOutputStream bout = null;
      ObjectOutputStream oout = null;
      
      try {
         
         out = new FileOutputStream("C:/Users/Samsung/Desktop/Bank/ClientList.txt");
         bout = new BufferedOutputStream(out);
         oout = new ObjectOutputStream(bout);
         oout.writeObject(c);
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            oout.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
   
   public void loadClientFile(){
      
      InputStream in = null;
      BufferedInputStream bin = null;
      ObjectInputStream oin = null;
      
      ClientList cl;
      
      try {
         in = new FileInputStream("C:/Users/Samsung/Desktop/Bank/ClientList.txt");
         bin = new BufferedInputStream(in);
         oin = new ObjectInputStream(bin);
         
         cl = (ClientList)oin.readObject();
         DataSet.getInstance().clientList = cl;
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            oin.close();
            bin.close();
            in.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
   
   public void saveAccountFile(AccountList a) {

      OutputStream out = null;
      BufferedOutputStream bout = null;
      ObjectOutputStream oout = null;
      
      try {
         
         out = new FileOutputStream("C:/Users/Samsung/Desktop/Bank/AccountList.txt");
         bout = new BufferedOutputStream(out);
         oout = new ObjectOutputStream(out);
         oout.writeObject(a);
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            oout.close();
            bout.close();
            out.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
   
   public void loadAccountFile(){
      
      InputStream in = null;
      BufferedInputStream bin = null;
      ObjectInputStream oin = null;
      
      AccountList al;
      
      try {
         in = new FileInputStream("C:/Users/Samsung/Desktop/Bank/AccountList.txt");
         bin = new BufferedInputStream(in);
         oin = new ObjectInputStream(in);
         
         al = (AccountList)oin.readObject();

         DataSet.getInstance().accountList = al;
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            oin.close();
            bin.close();
            in.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
   
   public void saveTradeRecordFile(TradeRecordList a) {
      
      OutputStream out = null;
      BufferedOutputStream bout = null;
      ObjectOutputStream oout = null;
      
      try {
         
         out = new FileOutputStream("C:/Users/Samsung/Desktop/Bank/TradeRecordList.txt");
         bout = new BufferedOutputStream(out);
         oout = new ObjectOutputStream(bout);
         oout.writeObject(a);
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            oout.close();
            bout.close();
            out.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
   
   public void loadTradeRecordFile(){
      
      InputStream in = null;
      BufferedInputStream bin = null;
      ObjectInputStream oin = null;
      
      TradeRecordList tl;
      
      try {
         in = new FileInputStream("C:/Users/Samsung/Desktop/Bank/TradeRecordList.txt");
         bin = new BufferedInputStream(in);
         oin = new ObjectInputStream(bin);
         
         tl = (TradeRecordList)oin.readObject();

         DataSet.getInstance().tradeRecordList = tl;
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            oin.close();
            bin.close();
            in.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
   
   public void savePromotionFile(String s) {
      OutputStream out = null;
      BufferedOutputStream bout = null;
      ObjectOutputStream oout = null;
      
      try {
         
         out = new FileOutputStream("C:/Users/Samsung/Desktop/Bank/Promotion.txt");
         bout = new BufferedOutputStream(out);
         oout = new ObjectOutputStream(bout);
         oout.writeObject(s);
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            oout.close();
            bout.close();
            out.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
   
   public String loadPromotionFile(){
      
      InputStream in = null;
      BufferedInputStream bin = null;
      ObjectInputStream oin = null;
      
      String s = "";
      
      try {
         in = new FileInputStream("C:/Users/Samsung/Desktop/Bank/Promotion.txt");
         bin = new BufferedInputStream(in);
         oin = new ObjectInputStream(bin);
         
         s = (String) oin.readObject();

      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            oin.close();
            bin.close();
            in.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
      
      return s;
   }

}