
package Servlet;

import Entity.Choices;
import Entity.Dao.DaoChoices;
import Entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SrvBtnVoted extends HttpServlet {

        Connection connection = null; 
        Statement statement = null; 
        ResultSet resultSet = null; 
 
        private String url = "jdbc:mysql://localhost/voting"; 
        private String user = "root"; 
        private String password = ""; 
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8, ISO-8859-1");
        try (PrintWriter out = response.getWriter()) {
            try {
                HttpSession httpSession = request.getSession();
                // login first to voting
                String userNow1 = (String) httpSession.getAttribute("current-user");
                if(userNow1==null){
                    httpSession.setAttribute("message", "You are not logged in !! Login first");
                    response.sendRedirect("login.jsp");
                    return;
                }
                
                
                 Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                 connection = DriverManager.getConnection(url, user, password);      
                 statement = connection.createStatement();
                 
                 // get Data information 
                Users userNow = (Users) httpSession.getAttribute("currentUser");   
                String idoption = request.getParameter("idoption");
                String nameoption = request.getParameter("nameoption");
                String idchoice1 = request.getParameter("idchoice");
                if(idchoice1==null){
                    httpSession.setAttribute("message","Select choice first to voted ..." );
                    response.sendRedirect("index.jsp");
                    return;
                }else{
                    int idchoice =Integer.parseInt(idchoice1);
                    String namechoice="";
                    int prcntj=0;
                    //
                 DaoChoices daoChoices =new DaoChoices();
                 List<Choices> listChoicesbyid =daoChoices.getAllChoicesByidch(idchoice);
                
                for(Choices ch: listChoicesbyid){
                    namechoice=ch.getChName();
                    prcntj=ch.getChPrsntg();
                }
                prcntj=prcntj+1;
                String isvoted= "INSERT INTO `useroption` (`iduser`, `idoption`,`idchoice`) "
                                  + "VALUES ('"+userNow.getUserId()+"', '"+idoption+"' , '"+idchoice+"' );";
                int n1 = statement.executeUpdate(isvoted);
                
                String addprsntj= "UPDATE `choices` SET `chprsntg` = '"+prcntj+"' WHERE `choices`.`chid` = "+idchoice+";";
                int n2 = statement.executeUpdate(addprsntj);
                
                httpSession.setAttribute("message",userNow.getUserName()+" Is Voted Now-OPtion : "+nameoption+" - choice : "+namechoice );
                response.sendRedirect("index.jsp");
                return;
                }
                
                
            } catch (Exception e) {
                out.print("processRequest : " + e.getMessage());
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
