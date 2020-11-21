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
        
       <header class="header" style="font-family: cursive">
       	<div class="container mt-3 ">
       		<div class="row">
       			
       			<div class="col-sm-6">
       				<h1>You Want To Voting !! </h1>
       				<p class="big-text"> Welcome! Voting online..</p>
       				<p>Welcome! With Us u can now to voting online.. Welcome! With Us u can now to voting online.. Welcome! With Us u can now to voting online.. </p>

       				<a href="normal.jsp" class="btn1 btn btn-first"> Voting Now</a>
       				<a href="login.jsp" class="btn1 btn btn-second">Login</a>

       			</div>

       			<div class="col-sm-3">
       				
       			</div>
       			<div class="col-sm-3">
       				<img src="img/vote.png" class="img-responsive">
       			</div>
       		</div>
       	</div>
       </header> 
  
    </body>
</html>
