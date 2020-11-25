package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class SrvOptions extends HttpServlet {

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

                String operation = request.getParameter("operation");

                //Connect to Add Category or product
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.createStatement();
                //-------------------------------------------------------------------------------------------------------------------------
                if (operation.trim().equals("addcategory")) {
                    // So add category
                    String catTitel = request.getParameter("catTitel").toString();

                    String query = "INSERT INTO `category` (`catId`, `catName`) VALUES (NULL, '" + catTitel + "');";
                     int n = statement.executeUpdate(query);

                      HttpSession httpSession = request.getSession();
                      httpSession.setAttribute("message", "Category Add Successfully : "  +catTitel );
                     response.sendRedirect("admin.jsp");
                    return;

                    //------------------------------------------------------------------------------------------------------------------------- 
                } else if (operation.trim().equals("addoption")) {
                    // So add product
                    String opname = request.getParameter("opname");
                    int catId = Integer.parseInt(request.getParameter("catId"));

                    String query = "INSERT INTO `option` (`opid`, `opname`, `catid`, `opdate`) VALUES"
                                      + " (NULL, '" + opname + "', '" + catId + "', current_timestamp());";

                    int n = statement.executeUpdate(query);

                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("message", "Option Add Successfully : " + opname);
                    response.sendRedirect("admin.jsp");
                    return;

                } else if (operation.trim().equals("addchoice")) {
                    // So add product
                    String chname = request.getParameter("chname");
                    int chopid = Integer.parseInt(request.getParameter("chopId"));

                    String query = "INSERT INTO `choices` (`chid`, `chopid`, `chname`, `chprsntg`)"
                                      + " VALUES (NULL, '" + chopid + "', '" + chname + "', '0');";

                    int n = statement.executeUpdate(query);

                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("message", "Choice Add Successfully : " + chname);
                    response.sendRedirect("admin.jsp");
                    return;

                }

            } catch (Exception e) {
                out.println("\n -getLocalizedMessage : " + e.getLocalizedMessage());
                out.println("\n -getMessage : " + e.getMessage());
                out.println("\n -toString : " + e.toString());
                e.printStackTrace();
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
