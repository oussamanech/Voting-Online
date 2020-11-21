
<%@page import="Entity.Options"%>
<%@page import="Entity.Dao.DaoOptions"%>
<%@page import="Entity.Category"%>
<%@page import="Entity.Dao.DaoCategory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
      String userNow1 = (String) session.getAttribute("current-user");
      if(userNow1==null){
          session.setAttribute("message", "You are not logged in !! Login first");
          response.sendRedirect("login.jsp");
          return;
      }else{
            if(userNow1.equalsIgnoreCase("normal")){
                 session.setAttribute("message", "You are not Admin !! Do not Acces this page");
                 response.sendRedirect("login.jsp");
                 }
          
      }
    %>
    <%  %>
 
    <%
        DaoCategory daoCategory =new DaoCategory();
        List<Category> listcategorys=daoCategory.getAllCategory();
        
        DaoOptions daoOptions =new DaoOptions();
        List<Options> listOptions=daoOptions.getAlldaoOptions();

    %>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
           <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
         <%@include file="components/navbar.jsp" %>
        
         <div class="container admin">
             <!-- Top Page -->
             <div class="container-fluid mt-3" >
                <%@include file="components/message.jsp" %>
             </div>
             <!-- -->
             <div class="row mt-3">
                 
                 
                 
        
<!-- ***************************************add-category-modal *******************************-->
                 <div class="col-md-5">
                     
                     <div class="card" data-toggle="modal" data-target="#add-category-modal">
                         <div class="card-body text-center">
                             <div class="container">
                                 <img class="img-fluid rounded-circle" src="img/cat1.png" alt="Add Product Image" style="max-width: 70px;">
                             </div>
                             <h6 class="text-uppercase text-muted">Add New Category</h6>
                              
                         </div>
                     </div>
                     
                 </div>
<!-- ***************************************add-Options-modal *******************************-->
                 <div class="col-md-4">
                     
                     <div class="card" data-toggle="modal" data-target="#add-option-modal">
                         <div class="card-body text-center">
                             <div class="container">
                                 <img class="img-fluid rounded-circle" src="img/plus.png" alt="Add Product Image" style="max-width: 70px;">
                             </div>
                             <h6 class="text-uppercase text-muted">Add New Options</h6>
                              
                         </div>
                     </div>
                     
                 </div>
  <!-- ***************************************add-choice-modal *******************************-->
                 <div class="col-md-3">
                     
                     <div class="card" data-toggle="modal" data-target="#add-choice-modal">
                         <div class="card-body text-center">
                             <div class="container">
                                 <img class="img-fluid rounded-circle" src="img/plus.png" alt="Add Product Image" style="max-width: 70px;">
                             </div>
                             <h6 class="text-uppercase text-muted">Add New Choice</h6>
                              
                         </div>
                     </div>
                     
                 </div>               
  <!-- ******************************* fin **************************************************************************-->                  
                 
             </div>
         </div>

<!-- *************** Add options modal ******************************************-->


<!-- Modal -->
       <div class="modal fade" id="add-option-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog modal-lg" role="document">
           <div class="modal-content">
             <div class="modal-header custom-bg text-white">
               <h5 class="modal-title" id="exampleModalLabel">Fill Option details</h5>
               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                 <span aria-hidden="true">&times;</span>
               </button>
             </div>
             <div class="modal-body">

               <form action="SrvOptions" method="post">

                   <input type="hidden" value="addoption" name="operation"/>

                     <div class="form-group">
                         <input type="text" class="form-control" name="opname" placeholder="Entre Options Name" required />
                     </div>
                   
                   <div class="form-group">
                            <select class="form-control" name="catId">
                                <% for(Category c1:listcategorys){  %>
                                <option value="<%=c1.getCatId()%>">
                                    <%=c1.getCatName()%>
                                </option>
                                
                                <% }%>
                            </select>
                          </div>

                     <div class="container text-center">
                         <button class="btn btn-outline-success" >
                             Add Option
                         </button>
                          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                     </div>



                 </form>

             </div>

           </div>
         </div>
       </div>

    <!-- End Add options modal -->
    
<!-- *************** Add cattegory modal ******************************************-->


<!-- Modal -->
       <div class="modal fade" id="add-category-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog modal-lg" role="document">
           <div class="modal-content">
             <div class="modal-header custom-bg text-white">
               <h5 class="modal-title" id="exampleModalLabel">Fill Category details</h5>
               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                 <span aria-hidden="true">&times;</span>
               </button>
             </div>
             <div class="modal-body">

               <form action="SrvOptions" method="post">

                   <input type="hidden" value="addcategory" name="operation"/>

                     <div class="form-group">
                         <input type="text" class="form-control" name="catTitel" placeholder="Entre Category Titel" required />
                     </div>

                     <div class="container text-center">
                         <button class="btn btn-outline-success" >
                             Add Category
                         </button>
                          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                     </div>



                 </form>

             </div>

           </div>
         </div>
       </div>

    <!-- End Add cattegory modal -->
    
<!-- *************** Add choice modal ******************************************-->


<!-- Modal -->
       <div class="modal fade" id="add-choice-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog modal-lg" role="document">
           <div class="modal-content">
             <div class="modal-header custom-bg text-white">
               <h5 class="modal-title" id="exampleModalLabel">Fill Choice details</h5>
               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                 <span aria-hidden="true">&times;</span>
               </button>
             </div>
             <div class="modal-body">

               <form action="SrvOptions" method="post">

                   <input type="hidden" value="addchoice" name="operation"/>

                   <div class="form-group">
                       <select class="form-control" name="chopId">
                                <% for(Options c1: listOptions){  %>
                                <option value="<%=c1.getOpId()%>">
                                    <%=c1.getOpName()%>
                                </option>
                                
                                <% }%>
                       </select>
                    </div>
                   
                     <div class="form-group">
                         <input type="text" class="form-control" name="chname" placeholder="Entre choice name" required />
                     </div>

                     <div class="container text-center">
                         <button class="btn btn-outline-success" >
                             Add choice
                         </button>
                          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                     </div>



                 </form>

             </div>

           </div>
         </div>
       </div>

    <!-- End Add choice modal -->

    
    <!-- ************************************************************************************************** -->
     <%@include file="components/panel.jsp" %> 
     
 
  
  
  
  
  
    </body>
</html>
