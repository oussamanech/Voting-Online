
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <%@include file="components/common_css_js.jsp" %>
        
        <title>Regestire</title>
    </head>
    <body>
        
               <%@include file="components/navbar.jsp" %>
               <div class="container-fluid">
                   
                            <div class="row mt-3">
                   <div class="col-md-6 offset-md-3">
                       
                       <div class="card">
                           <%@include file="components/message.jsp" %>
                           
                           <div class="card-body px-5">
                                <h3 class="text-center my-3"> Sing up !</h3>
                       
                                <form action="SrvRegester" method="post">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input name="uname" type="text" class="form-control" id="name" placeholder="Entre Here" aria-describedby="emailHelp" required>
                           </div>
                            <div class="form-group">
                                <label for="ufamily">Name</label>
                                <input name="ufamily" type="text" class="form-control" id="ufamily" placeholder="Entre Here" aria-describedby="emailHelp" required>
                           </div>
                                                             
                           <div class="form-group">
                                <label for="email">Email</label>
                                <input name="uemail" type="email" class="form-control" id="email" placeholder="Entre Here" aria-describedby="emailHelp" required>
                           </div>
                           
                           <div class="form-group">
                                <label for="password">Password</label>
                                <input name="upassword" type="password" class="form-control" id="email" placeholder="Entre Here" aria-describedby="emailHelp" required>
                           </div>
                             
                           <div class="form-group">
                                <label for="phone">Phone</label>
                                <input name="uphone" type="number" class="form-control" id="email" placeholder="Entre Here" aria-describedby="emailHelp" required>
                           </div>
                                                      
                           <div class="container text-center">
                               <button class="btn btn-outline-success">Register</button>
                               <button class="btn btn-outline-warning">Reset</button>
                           </div>
                           
                       </form>
                           </div>
                       </div>
                      
                       
                   </div>
               </div>
                   
               </div>
                           
    </body>
</html>
