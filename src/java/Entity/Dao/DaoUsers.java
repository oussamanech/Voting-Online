
package Entity.Dao;

import Entity.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUsers {
    
    Connection connection = null; 
    Statement statement = null; 
    ResultSet resultSet = null; 

     String url = "jdbc:mysql://localhost/voting"; 
     String user = "root"; 
     String password = ""; 
    
   public Users getUserPyEmailAndPassword(String e,String p){
        Users u1=null;
     
        try {
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, password);      
            statement = connection.createStatement();
             String query = "SELECT * FROM `user` WHERE `uemail`='"+e+"' AND `upassword`='"+p+"';" ;
            resultSet = statement.executeQuery(query);
        
             while(resultSet.next()){
                Users u=new Users();
                u.setUserEmail(e);
                u.setUserPassword(p);
                u.setUserId(Integer.parseInt(resultSet.getString("uid") ));
                u.setUserName(resultSet.getString("uname"));                
                u.setUserFamily(resultSet.getString("ufamily"));                
                u.setUserPhone(resultSet.getString("uphone"));
                u.setUserType(resultSet.getString("utype"));
                u1=u;
             }
             connection.close();
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        
        return u1;
    }
     
   public List<Users> getAllUsers(){
        List<Users> u1 = new ArrayList<Users>();
     
        try {
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, password);      
            statement = connection.createStatement();
             String query = "SELECT * FROM `user`;" ;
            resultSet = statement.executeQuery(query);
        
             while(resultSet.next()){
                Users u=new Users();
                u.setUserEmail(resultSet.getString("uemail"));
                u.setUserPassword(resultSet.getString("upassword"));
                u.setUserId(Integer.parseInt(resultSet.getString("uid") ));
                u.setUserName(resultSet.getString("uname"));                
                u.setUserFamily(resultSet.getString("ufamily"));                
                u.setUserPhone(resultSet.getString("uphone"));
                u.setUserType(resultSet.getString("utype"));
                u1.add(u);
             }
             connection.close();
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        
        return u1;
    }
     
}
