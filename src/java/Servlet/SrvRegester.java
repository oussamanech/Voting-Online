package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SrvRegester extends HttpServlet {

    
        Connection connection = null; 
        Statement statement = null; 
        ResultSet resultSet = null; 
 
        private String url = "jdbc:mysql://localhost/voting"; 
        private String user = "root"; 
        private String password = ""; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8 , ISO-8859-1");
        try (PrintWriter out = response.getWriter()) {
            
            try {
                String uname = request.getParameter("uname");
                String ufamily = request.getParameter("ufamily");
                String uemail = request.getParameter("uemail");
                String upassword = request.getParameter("upassword");
                String uphone = request.getParameter("uphone");
                
                // Validation
                
                if (uname.isEmpty()) {
                    out.print("userName.isEmpty()");
                }
                
                // Enregistrer

                        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                        connection = DriverManager.getConnection(url, user, password);      
                        statement = connection.createStatement(); 
                     
            String query= "INSERT INTO `user` (`uid`, `uname`, `ufamily`, `uemail`, `upassword`, `uphone`, `utype`)"
                              + " VALUES (NULL, '"+uname+"', '"+ufamily+"', '"+uemail+"', '"+upassword+"', '"+uphone+"', 'normal')";
                  
                 int n = statement.executeUpdate(query);
                 
                 //------------------------- search  id -------------------
               String selectid ="SELECT * FROM `user` WHERE `uphone` LIKE "+uphone+" and `uemail` = '"+uemail+"';";
               resultSet = statement.executeQuery(selectid);
               String userIdNow="No Id";
                if (resultSet.next()) {
                   userIdNow= resultSet.getString("uid");
                }
              
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("message", "Registration Successful !! User Id : " + userIdNow  );
                
                response.sendRedirect("regestire.jsp");
          
                
                connection.close();
            } catch (Exception e) {
               out.println( "\n -getLocalizedMessage : "  +e.getLocalizedMessage());
              // out.println( "\n -getMessage : "  +e.getMessage());
              // out.println( "\n -toString : "  +e.toString());
               e.printStackTrace() ;
            }            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
