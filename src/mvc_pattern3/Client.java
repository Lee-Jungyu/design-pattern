package mvc_pattern3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Client implements Subject, Serializable{
   private String name;
   private Date joiningDate; 
   private String password;
   private String id;
   private String nationalIdNo;
   private String clientType;
   
   private ArrayList<Observer> observers;
   
   public Client(String name, String nationalIdNo, String id, String password){
      this.setName(name);
      this.setNationalIdNo(nationalIdNo);
      this.setId(id);
      this.setPassword(password);
      clientType = "guest";
      observers = new ArrayList<Observer>();
   }
   
   public String getClientType() {
      return clientType;
   }
   
   public void setClientType(String s) {
      clientType = s;
   }
   
   @Override
   public void registerObservers(Observer o) {
      // TODO Auto-generated method stub
      observers.add(o);
   }
   @Override
   public void removeObservers(Observer o) {
      // TODO Auto-generated method stub
      observers.remove(o);
   }
   @Override
   public void notifyObservers() {
      // TODO Auto-generated method stub
      for (int i = 0; i < observers.size(); i++)
      {
         Observer observer = (Observer)observers.get(i);
         observer.update(this);
      }
   }


   public String getName() {
      return name;
   }


   public void setName(String name) {
      this.name = name;
   }

   public Date getJoiningDate() {
      return joiningDate;
   }


   public void setJoiningDate(Date joiningDate) {
      this.joiningDate = joiningDate;
   }


   public String getPassword() {
      return password;
   }


   public void setPassword(String password) {
      this.password = password;
   }


   public String getId() {
      return id;
   }


   public void setId(String id) {
      this.id = id;
   }


   public String getNationalIdNo() {
      return nationalIdNo;
   }


   public void setNationalIdNo(String nationalIdNo) {
      this.nationalIdNo = nationalIdNo;
   }
}