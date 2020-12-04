
<%@page import="Entity.Options"%>
<%@page import="Entity.Dao.DaoOptions"%>
<%@page import="Entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Dao.DaoCategory"%>
<%@page import="Entity.Users"%>
<%
    String usertype = (String) session.getAttribute("current-user");
    String userNowName = (String) session.getAttribute("current-username");

    Users u = (Users) session.getAttribute("currentUser");

    DaoCategory daoCategory1 = new DaoCategory();
    List<Category> listcategorys1 = daoCategory1.getAllCategory();

    //----------------------------------------------------------------
    String login = (String) session.getAttribute("login");
    String creat = (String) session.getAttribute("creat");
    String titre = (String) session.getAttribute("titre");
    //*********
    String Home = (String) session.getAttribute("Home");
    String votingnow = (String) session.getAttribute("votingnow");
    String cati = (String) session.getAttribute("cat");
    String allcati = (String) session.getAttribute("allcat");
    String service = (String) session.getAttribute("service");
    String about = (String) session.getAttribute("about");
    String contact = (String) session.getAttribute("contact");
    //**********************
    String logout = (String) session.getAttribute("logout");
%>

<nav class="navbar navbar-expand-lg navbar-dark custom-bg" style="font-family: cursive">

    <nav class="container navbar-style " >


        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-header" >
            <a href="index.jsp"><img src="img/logo.png" class="logo"></a>
        </div>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav  navbar-right mr-auto ">
            </li><li class="nav-item active">
            <a class="nav-link" href="index.jsp" ><%=Home%> </a>
        </li>

    </li><li class="nav-item active">
    <a class="nav-link" href="normal.jsp" ><%=votingnow%></a>
</li>


<li class="nav-item dropdown">
    <a style="font-family: cursive" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <%=cati%>
    </a>
    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <a href="normal.jsp?category=all" class="list-group-item list-group-item-action active"><%=allcati%></a>
        <%  for (Category c1 : listcategorys1) {%> 
        <a class="dropdown-item" href="normal.jsp?category=<%=c1.getCatId()%>"><%=c1.getCatName()%></a>
        <%  }   %>
    </div>
</li> 


</li><li class="nav-item active">
<a class="nav-link" href="index.jsp"><%=service%></a>
</li>
</li><li class="nav-item active">
<a class="nav-link" href="index.jsp"><%=about%></a>
</li>
</li><li class="nav-item active">
<a class="nav-link" href="index.jsp"><%=contact%></a>
</li>

</ul>

<ul class="navbar-nav ml-auto">

    <%
        if (usertype == null) {
    %> 
    <li class="nav-item active">
        <a class="nav-link" href="login.jsp"><%=login%>  </a>
    </li>
    <li class="nav-item active">
        <a class="nav-link" href="regestire.jsp"><%=creat%></a>
    </li> 
    <%   } else {%> 
    <li class="nav-item active">
        <a class="nav-link" href="<%=u.getUserType().equals("admin") ? "admin.jsp" : "normal.jsp"%>">  <%=u.getUserName()%>(Controle Panel)  </a>
    </li>
    <li class="nav-item active">
        <a class="nav-link" href="Srvlogout"> <%=logout%> </a>
    </li>  

    <% }%>


</ul>


</div>

</nav>

</nav>