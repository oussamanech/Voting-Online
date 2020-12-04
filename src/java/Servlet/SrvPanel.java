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

public class SrvPanel extends HttpServlet {

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
            HttpSession httpSession = request.getSession();
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.createStatement();

                //get id name :
                String idd = request.getParameter("id");
                String namee = request.getParameter("name");

                //Get Parameter operation
                String operation = request.getParameter("operation");
                // remove Category or update
                if (operation.equalsIgnoreCase("catdelete")) {
                    String rmv = "DELETE FROM `category` WHERE `category`.`catId` = " + idd + ";";
                    int n = statement.executeUpdate(rmv);
                    String rmv2 = "DELETE FROM `option` WHERE `option`.`catid` = " + idd + ";";
                    int n2 = statement.executeUpdate(rmv2);
                    httpSession.setAttribute("message", "Delete Category : " + namee);
                    response.sendRedirect("admin.jsp");
                    return;
                }

                if (operation.equalsIgnoreCase("catupdate")) {
                    String rmv = "UPDATE `category` SET `catName` = '" + namee + "' WHERE `category`.`catId` = " + idd + ";";
                    int n = statement.executeUpdate(rmv);
                    httpSession.setAttribute("message", "Update Category : " + namee);
                    response.sendRedirect("admin.jsp");
                    return;
                }
                // remove option or update
                if (operation.equalsIgnoreCase("optiondelete")) {
                    String rmv = "DELETE FROM `option` WHERE `option`.`opid` = " + idd + ";";
                    int n = statement.executeUpdate(rmv);
                    String rmv2 = "DELETE FROM `choices` WHERE `choices`.`chopid` = " + idd + ";";
                    int n2 = statement.executeUpdate(rmv2);
                    httpSession.setAttribute("message", "Delete Option : " + namee);
                    response.sendRedirect("admin.jsp");
                    return;
                }

                if (operation.equalsIgnoreCase("optionupdate")) {
                    String rmv = "UPDATE `option` SET `opname` = '" + namee + "' WHERE `option`.`opid` = " + idd + ";";
                    int n = statement.executeUpdate(rmv);
                    httpSession.setAttribute("message", "Update Option : " + namee);
                    response.sendRedirect("admin.jsp");
                    return;
                }
                // remove choices or update
                if (operation.equalsIgnoreCase("chdelete")) {
                    String rmv = "DELETE FROM `choices` WHERE `choices`.`chid` = " + idd + ";";
                    int n = statement.executeUpdate(rmv);

                    httpSession.setAttribute("message", "Delete Choice : " + namee);
                    response.sendRedirect("admin.jsp");
                    return;
                }

                if (operation.equalsIgnoreCase("chupdate")) {
                    String rmv = "UPDATE `choices` SET `chname` = '" + namee + "' WHERE `choices`.`chid` = " + idd + ";";
                    int n = statement.executeUpdate(rmv);
                    httpSession.setAttribute("message", "Update Choice : " + namee);
                    response.sendRedirect("admin.jsp");
                    return;
                }
                // remove Users
                if (operation.equalsIgnoreCase("userdelete")) {
                    String rmv = "DELETE FROM `user` WHERE `user`.`uid` = " + idd + ";";
                    int n = statement.executeUpdate(rmv);

                    httpSession.setAttribute("message", "Delete User : " + namee);
                    response.sendRedirect("admin.jsp");
                    return;
                }

            } catch (Exception e) {
                out.println("\n -getLocalizedMessage : " + e.getLocalizedMessage());
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
