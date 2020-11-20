<%@page import="Entity.Dao.DaoUsers_Options"%>
<%@page import="Entity.Dao.DaoUsers"%>
<%@page import="Entity.Choices"%>
<%@page import="Entity.Dao.DaoChoices"%>
<%@page import="Entity.Options"%>
<%@page import="Entity.Dao.DaoOptions"%>
<%@page import="Entity.Category"%>
<%@page import="Entity.Dao.DaoCategory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Users userNow = (Users) session.getAttribute("currentUser");   
    
    DaoUsers_Options duo= new DaoUsers_Options();
    
        DaoCategory daoCategory =new DaoCategory();
        List<Category> listcategorys=daoCategory.getAllCategory();
        
        DaoOptions daoOptions =new DaoOptions();
        List<Options> listOptions=daoOptions.getAlldaoOptions();
       
        DaoChoices daoChoices =new DaoChoices();
        List<Choices> listChoices =null;
        //List<Choices> listChoices =daoChoices.getAllChoices();

        // cat page index
        String cat=request.getParameter("category");
        if(cat == null || cat.trim().equalsIgnoreCase("all") ){
                listOptions=daoOptions.getAlldaoOptions();

          }else{
              int catId1=Integer.parseInt(cat);
              listOptions=daoOptions.getAlldaoOptions(catId1);
          }
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%@include file="components/common_css_js.jsp" %>
       
        <title>Voting - 2020 </title>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        
        <header class="header">
            <nav class=" navbar navbar-style">
                <div class="container">
                	<div class="navbar-header">
                		
                	</div>
                    
                </div>
            </nav>
        </header>
        
        
        
        
        <div class="container-fluid mt-3">
            <%@include file="components/message.jsp" %>
        <div class="row mx-2">
            
        <div class="col-md-2">
               
                <div class="list-group mt-4">
                    <a href="index.jsp?category=all" class="list-group-item list-group-item-action active">All Category</a>
                   <%
                    for(Category c1:listcategorys){
                     %>  
                     <a href="index.jsp?category=<%=c1.getCatId()%>" class="list-group-item list-group-item-action "> <%=c1.getCatName()%> </a>
                    <%
                    }
                    %>
                </div>
                
              
            </div>
      <div class="col-md-10">
       <!-- Row -->
                <div class="row mt-4">
                    
                    <!-- Col : 12 -->
                    <div class="col-md-12 ">    
            <!-- Cards -->
         <div class="card-columns">
         <!--  <div class="card-deck">  -->
              
             <% for(Options c1: listOptions){
             
                 listChoices=daoChoices.getAllChoices(c1.getOpId());
                 if(!(listChoices.isEmpty()) ){ 
             %>
                   <!-- Card 01 -->
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%=c1.getOpName()%></h5>

                       
        <!-- ******************************** form ******************************************************* -->   
                   
             <form action="SrvBtnVoted" method="post">
                    
                   <% 
                    for(Choices ch: listChoices){  
                    
                    %>
                        
                 <%if( userNow!= null){
                if(duo.isVoted(userNow.getUserId(), c1.getOpId()) ){ 
                 int TotalVoted = daoChoices.getNmbrVotedByIdOpt(c1.getOpId());
                 int nbrVoted =daoChoices.getNmbrVotedChooice(ch.getChId());
                 double rs= (nbrVoted * 100) / TotalVoted;
                
               //  String rsl =String.valueOf(rs).substring(0, 5); 
               %>  <h6><%=ch.getChName()%> </h6>
                    <div class="progress">
                       <div class="progress-bar bg-info" role="progressbar" style="width: <%=rs%>%;" aria-valuenow="<%=rs%>" aria-valuemin="0" aria-valuemax="100"><%=rs%>% </div>
                    </div>
                 <% }else{ %>
                    <!--Radio group-->
                        <div class="form-check radio-green">
                            <input type="radio" class="form-check-input" id="<%=ch.getChId()%>" value="<%=ch.getChId()%>" name="idchoice">
                            <label class="form-check-label" for="radioGreen1"><%=ch.getChName()%> </label>
                        </div> 
            <% }}else{ %>   
                    <!--Radio group-->
                        <div class="form-check radio-green">
                            <input type="radio" class="form-check-input" id="<%=ch.getChId()%>" value="<%=ch.getChId()%>" name="idchoice">
                            <label class="form-check-label" for="radioGreen1"><%=ch.getChName()%> </label>
                        </div> 
            <% } %>  
                 
                        
                        
                <% } %>
                    
                </div>
                
                <div class="card-footer">
                
                   <input type="hidden" value="<%=c1.getOpId()%>" name="idoption"/>
                   <input type="hidden" value="<%=c1.getOpName()%>" name="nameoption"/>
                   
            <%if( userNow!= null){
                if(duo.isVoted(userNow.getUserId(), c1.getOpId()) ){ %>                 
                <small class="text-muted"> U are voting here : <%=duo.nameChoiceSelected(userNow.getUserId(), c1.getOpId())%> </small>
                  
            <% }else{ %>
                    <button class="btn btn-outline-success btn-secondary text-white">Voted</button> 
            <% }}else{ %>   
                    <button class="btn btn-success text-white">Voted</button> 
            <% } %>  
                      
                  <small class="text-muted"> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <%=c1.getOpDate().substring(0, 16)%> </small>
                  </form> 
                </div>
               
            </div> 
             <% }} %>
              
             
            
          </div>
            
  <!-- fin cards -->
      </div>
      </div>  
      </div> 
  <!-- fiiiiiiiiiiiiiiiiiiiiin -->
        </div>
        </div>
            
            
            
        
 
    </body>
</html>
