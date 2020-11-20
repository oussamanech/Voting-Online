
package Entity.Dao;

import Entity.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCategory {
    
    Connection connection = null; 
    Statement statement = null; 
    ResultSet resultSet = null; 

     String url = "jdbc:mysql://localhost/voting"; 
     String user = "root"; 
     String password = "";     
    
    public List<Category> getAllCategory(){
     List<Category> categorys = new ArrayList<Category>();
                     try {
                       Class.forName ("com.mysql.jdbc.Driver").newInstance();
                       connection = DriverManager.getConnection(url, user, password);      
                       statement = connection.createStatement();
                       String query = "SELECT * FROM `category`;" ;
                    resultSet = statement.executeQuery(query);

                      while(resultSet.next()){     
                      Category c=new Category();
                      c.setCatId( Integer.valueOf(resultSet.getString("catId")) );
                      c.setCatName(resultSet.getString("catName"));

                      categorys.add(c);
                      }
                     } catch (Exception e) {
                                       e.getLocalizedMessage();
                  }
                     return categorys;
        }


    
    
}
