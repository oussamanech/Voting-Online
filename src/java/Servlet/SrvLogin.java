
package Servlet;

import Entity.Dao.DaoUsers;
import Entity.Users;
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

public class SrvLogin extends HttpServlet {

        Connection connection = null; 
        Statement statement = null; 
        ResultSet resultSet = null; 
 
        private String url = "jdbc:mysql://localhost/voting"; 
        private String user = "root"; 
        private String password = ""; 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
             try {
                 
                 Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                 connection = DriverManager.getConnection(url, user, password);      
                 statement = connection.createStatement();
                 
                 // coding area
                String eml = request.getParameter("email");
                String pas = request.getParameter("password");
                
                //validation
                
                //authenticating user
                 DaoUsers daoUsers =new DaoUsers();
                 Users us = daoUsers.getUserPyEmailAndPassword(eml, pas);
                 HttpSession httpSession = request.getSession();
                 
                 if(us == null){
                      httpSession.setAttribute("message", "Invailed Detail !! try with another one  "); 
                      response.sendRedirect("login.jsp");
                      return;
                 }else{
                     httpSession.setAttribute("current-user", us.getUserType());
                     httpSession.setAttribute("currentUser", us);
                     httpSession.setAttribute("current-username", us.getUserName());
                     
                     if(us.getUserType().equalsIgnoreCase("admin")){
                                  response.sendRedirect("index.jsp");
                              }else 
                                  if(us.getUserType().equalsIgnoreCase("normal")){
                                  response.sendRedirect("index.jsp");
                              }else{
                                  httpSession.setAttribute("message", "We have not your identified user type");
                              }
                     
                 }
                 
                 
            } catch (Exception e) {
               out.println( "\n -getLocalizedMessage : "  +e.getLocalizedMessage());
               out.println( "\n -getMessage : "  +e.getMessage());
               out.println( "\n -toString : "  +e.toString());
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
