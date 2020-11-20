
   <%@page import="Entity.Users"%>
<%
       String usertype = (String) session.getAttribute("current-user");
       String userNowName = (String) session.getAttribute("current-username");
    
      Users u= (Users) session.getAttribute("currentUser");

    
    %>

<nav class="navbar navbar-expand-lg navbar-dark custom-bg" >

    <nav class="container">
        
          <a class="navbar-brand" href="index.jsp">Vote</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                 <ul class="navbar-nav mr-auto">
                   <li class="nav-item active">
                     <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                   </li>
                  <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       Categories
                     </a>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                       <a class="dropdown-item" href="#">Action</a>
                       <a class="dropdown-item" href="#">Another action</a>
                       <div class="dropdown-divider"></div>
                       <a class="dropdown-item" href="#">Something else here</a>
                     </div>
                   </li> 
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       Categories
                     </a>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                       <a class="dropdown-item" href="#">Action</a>
                       <a class="dropdown-item" href="#">Another action</a>
                       <div class="dropdown-divider"></div>
                       <a class="dropdown-item" href="#">Something else here</a>
                     </div>
                   </li>
                 </ul>

                <ul class="navbar-nav ml-auto">
                   
                    <%
                        if(usertype==null){
                    %> 
                        <li class="nav-item active">
                           <a class="nav-link" href="login.jsp">Login  </a>
                        </li>
                        <li class="nav-item active">
                           <a class="nav-link" href="regestire.jsp"> Regestire </a>
                        </li> 
                      <%   }else{       %> 
                       <li class="nav-item active">
                           <a class="nav-link" href="<%=u.getUserType().equals("admin")?"admin.jsp":"normal.jsp"%>">  <%=u.getUserName() %>  </a>
                      </li>
                      <li class="nav-item active">
                           <a class="nav-link" href="Srvlogout"> logout </a>
                      </li>  
                          
                      <% } %>
                    
                     
                </ul>


               </div>

    </nav>
    
</nav>