package mvc_pattern3;

import javax.swing.JOptionPane;

public class OnlineBankingSystem {

   public static void main(String[] args) {
      DataSet ds = DataSet.getInstance();
      if(ds.getInstance().clientList.findclientWithId("admin") == null) {
         Client manager = new Client("admin","admin","admin","admin");
         manager.setClientType("admin");
         ds.getInstance().clientList.insertClient(manager);   
      }
      CommandController controller = new CommandController();
      LoginFrame loginFrame = new LoginFrame(controller);
   }

}