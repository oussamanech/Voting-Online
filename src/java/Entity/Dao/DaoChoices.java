
package Entity.Dao;

import Entity.Choices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoChoices {
   
    Connection connection = null; 
    Statement statement = null; 
    ResultSet resultSet = null; 

     String url = "jdbc:mysql://localhost/voting"; 
     String user = "root"; 
     String password = "";     
    
    public List<Choices> getAllChoices(){
     List<Choices> choiceses = new ArrayList<Choices>();
                     try {
                       Class.forName ("com.mysql.jdbc.Driver").newInstance();
                       connection = DriverManager.getConnection(url, user, password);      
                       statement = connection.createStatement();
                       String query = "SELECT * FROM `choices`;" ;
                    resultSet = statement.executeQuery(query);

                      while(resultSet.next()){     
                      Choices c=new Choices();
                      c.setChId(Integer.valueOf(resultSet.getString("chid")) );
                      c.setChOpId(Integer.valueOf(resultSet.getString("chopid")) );
                      c.setChPrsntg(Integer.valueOf(resultSet.getString("chprsntg")) );
                      c.setChName(resultSet.getString("chname"));

                      choiceses.add(c);
                      }
                     } catch (Exception e) {
                          e.getLocalizedMessage();
                  }
                     return choiceses;
        }
  
    public List<Choices> getAllChoices(int idOp){
     List<Choices> choiceses = new ArrayList<Choices>();
                     try {
                       Class.forName ("com.mysql.jdbc.Driver").newInstance();
                       connection = DriverManager.getConnection(url, user, password);      
                       statement = connection.createStatement();
                       String query = "SELECT * FROM `choices` where chopid like "+idOp+";" ;
                    resultSet = statement.executeQuery(query);
                    
                      while(resultSet.next()){     
                      Choices c=new Choices();
                      c.setChId(Integer.valueOf(resultSet.getString("chid")) );
                      c.setChOpId(Integer.valueOf(resultSet.getString("chopid")) );
                      c.setChPrsntg(Integer.valueOf(resultSet.getString("chprsntg")) );
                      c.setChName(resultSet.getString("chname"));

                      choiceses.add(c);
                      }
                     } catch (Exception e) {
                          e.getLocalizedMessage();
                  }
                     return choiceses;
        }
   
    public List<Choices> getAllChoicesByidch(int idch){
     List<Choices> choiceses = new ArrayList<Choices>();
                     try {
                       Class.forName ("com.mysql.jdbc.Driver").newInstance();
                       connection = DriverManager.getConnection(url, user, password);      
                       statement = connection.createStatement();
                       String query = "SELECT * FROM `choices` where chid like "+idch+";" ;
                    resultSet = statement.executeQuery(query);

                      while(resultSet.next()){     
                      Choices c=new Choices();
                      c.setChId(Integer.valueOf(resultSet.getString("chid")) );
                      c.setChOpId(Integer.valueOf(resultSet.getString("chopid")) );
                      c.setChPrsntg(Integer.valueOf(resultSet.getString("chprsntg")) );
                      c.setChName(resultSet.getString("chname"));

                      choiceses.add(c);
                      }
                     } catch (Exception e) {
                          e.getLocalizedMessage();
                  }
                     return choiceses;
        }

    public String getNameChById(int idch){
       String nameCh="";
        try {
                Class.forName ("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, user, password);      
                statement = connection.createStatement();
                String query = "SELECT * FROM `choices` where chid like "+idch+";" ;
                resultSet = statement.executeQuery(query);

               if(resultSet.next()){
                   nameCh = resultSet.getString("chname");
               }
              } catch (Exception e) {
                          e.getLocalizedMessage();
              }
        return nameCh;
    }
    
    public int getNmbrVotedByIdOpt(int idop){
       int allvoted=0;
        try {
                Class.forName ("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, user, password);      
                statement = connection.createStatement();
                String query = "SELECT * FROM `choices` where chopid like "+idop+";" ;
                resultSet = statement.executeQuery(query);

               while(resultSet.next()){
                   allvoted =allvoted+ Integer.valueOf(resultSet.getString("chprsntg"));
               }
              } catch (Exception e) {
                          e.getLocalizedMessage();
              }
        return allvoted;
    }
   
    public int getNmbrVotedChooice(int idch){
       int nbr=0;
        try {
                Class.forName ("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, user, password);      
                statement = connection.createStatement();
                String query = "SELECT * FROM `choices` where chid like "+idch+";" ;
                resultSet = statement.executeQuery(query);

               if(resultSet.next()){
                   nbr = Integer.valueOf(resultSet.getString("chprsntg"));
               }
              } catch (Exception e) {
                          e.getLocalizedMessage();
              }
        return nbr;
    }
    
    
    
}
