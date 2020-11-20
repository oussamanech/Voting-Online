
package Entity.Dao;

import Entity.Options;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoOptions {
   
    Connection connection = null; 
    Statement statement = null; 
    ResultSet resultSet = null; 

     String url = "jdbc:mysql://localhost/voting"; 
     String user = "root"; 
     String password = "";     
    
    public List<Options> getAlldaoOptions(){
     List<Options> optionses = new ArrayList<Options>();
                     try {
                       Class.forName ("com.mysql.jdbc.Driver").newInstance();
                       connection = DriverManager.getConnection(url, user, password);      
                       statement = connection.createStatement();
                       String query = "SELECT * FROM `option`;" ;
                    resultSet = statement.executeQuery(query);

                      while(resultSet.next()){     
                      Options c=new Options();
                      c.setOpId(Integer.valueOf(resultSet.getString("opid")) );
                      c.setOpName(resultSet.getString("opname") );
                      c.setOpCatId(Integer.valueOf(resultSet.getString("catid")) );
                      c.setOpDate(resultSet.getString("opdate"));

                      optionses.add(c);
                      }
                     } catch (Exception e) {
                          e.getLocalizedMessage();
                  }
                     return optionses;
        }
    
    public List<Options> getAlldaoOptions(int idcat){
     List<Options> optionses = new ArrayList<Options>();
                     try {
                       Class.forName ("com.mysql.jdbc.Driver").newInstance();
                       connection = DriverManager.getConnection(url, user, password);      
                       statement = connection.createStatement();
                       String query = "SELECT * FROM `option` where `catid` like '"+idcat+"';" ;
                    resultSet = statement.executeQuery(query);

                      while(resultSet.next()){     
                      Options c=new Options();
                      c.setOpId(Integer.valueOf(resultSet.getString("opid")) );
                      c.setOpName(resultSet.getString("opname") );
                      c.setOpCatId(Integer.valueOf(resultSet.getString("catid")) );
                      c.setOpDate(resultSet.getString("opdate"));

                      optionses.add(c);
                      }
                     } catch (Exception e) {
                          e.getLocalizedMessage();
                  }
                     return optionses;
        }
    
}
