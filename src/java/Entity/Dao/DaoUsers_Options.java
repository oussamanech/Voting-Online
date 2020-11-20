
package Entity.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoUsers_Options {
    Connection  connection = null; 
    Statement statement = null; 
    ResultSet resultSet = null; 

    String url = "jdbc:mysql://localhost/voting"; 
    String user = "root"; 
    String password = "";       
     
    DaoChoices dc=new DaoChoices();
     
     
    public boolean isVoted(int iduser,int idoption){
        try {
                Class.forName ("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, user, password);      
                statement = connection.createStatement();
                String query = "SELECT * FROM `useroption` where `iduser` like '"+iduser+"' and `idoption` like '"+idoption+"';" ;
                resultSet = statement.executeQuery(query);

               if(resultSet.next()){    return true;} 
             
         } catch (Exception e) {
              e.getLocalizedMessage();
         }
          return false;
  }                    
   
    public String nameChoiceSelected(int iduser,int idoption){
       String namechoice="";
        try {
                Class.forName ("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, user, password);      
                statement = connection.createStatement();
                String query = "SELECT * FROM `useroption` where `iduser` like '"+iduser+"' and `idoption` like '"+idoption+"';" ;
                resultSet = statement.executeQuery(query);

               if(resultSet.next()){
               int idchoice = Integer.valueOf(resultSet.getString("idchoice"));
               namechoice = dc.getNameChById(idchoice);
               } 
             
         } catch (Exception e) {
              e.getLocalizedMessage();
         }
        return namechoice;
    }
}
