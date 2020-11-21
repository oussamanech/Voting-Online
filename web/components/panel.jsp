
<%@page import="Entity.Users"%>
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
      DaoCategory daoCategory2 =new DaoCategory();
        List<Category> listcategorys2=daoCategory2.getAllCategory();
        
        DaoOptions daoOptions2 =new DaoOptions();
        List<Options> listOptions2=daoOptions2.getAlldaoOptions();

        DaoChoices daoChoices2=new DaoChoices();
        List<Choices> listChoiceses2=daoChoices2.getAllChoices();
        
        DaoUsers daoUsers2 = new DaoUsers();
        List<Users> listUser2 = daoUsers2.getAllUsers();
    
    %>



<div class="container">
    <div class="container admin">
        <!-- list category Top Page -->
        <div class="container-fluid mt-3 text-center" >
            <h1>List Category </h1>
        </div>
        <!-- -->
        <div class="row mt-3">
    <table class="table">
     <thead class="thead-dark">
    <tr>
      <th scope="col">#Id</th>
      <th scope="col">Name</th>
      <th scope="col">Action</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
      <% for(Category c1:listcategorys2){  %>
      <tr>
   <!-- Category update -->
  <form action="SrvPanel" method="post">
        <input type="hidden" value="catupdate" name="operation"/>
        <input type="hidden" name="id" value="<%=c1.getCatId()%>" >
                        
                        
      <th scope="row"><%=c1.getCatId()%></th>
      
        <td><div class="form-group">
            <input name="name" value="<%=c1.getCatName()%>" type="text" required>
         </div>  </td>
      <td><button class="btn btn-primary" >Update </button></td>
      </form>
  <!-- Category remove -->
      <form action="SrvPanel" method="post">
      <input type="hidden" name="operation" value="catdelete"/>
      <input type="hidden" name="id"        value="<%=c1.getCatId()%>" >
      <input type="hidden" name="name"      value="<%=c1.getCatName()%>" >
      <td><button class="btn btn-danger" >Remove </button></td>
      
      </form>
      
      </tr>
    <% }%>
  </tbody>
</table>
            
             </div>
    </div>  
  
    <div class="container admin">
        <!-- List Option Top Page -->
        <div class="container-fluid mt-3 text-center" >
            <h1> List Options </h1>
        </div>
        <!-- -->
        <div class="row mt-3">
    <table class="table">
     <thead class="thead-dark">
    <tr>
      <th scope="col">#Id</th>
      <th scope="col">Name</th>
      <th scope="col">Cat Id</th>
      <th scope="col">Date Add</th>
      <th scope="col">Action</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
      <% for(Options c1: listOptions2){  %>
      <tr>
          
          <!-- OPTION update -->
  <form action="SrvPanel" method="post">
        <input type="hidden" value="optionupdate" name="operation"/>
        <input type="hidden" name="id" value="<%=c1.getOpId()%>" >
         
      <th scope="row"><%=c1.getOpId()%></th>
      <td><div class="form-group">
            <input name="name" value="<%=c1.getOpName()%>" type="text" required>
         </div>  </td> 
      <td><%=c1.getOpCatId()%></td>
      <td><%=c1.getOpDate()%></td>
      <td><button class="btn btn-primary" >Update </button></td>
      </form>
  
      <form action="SrvPanel" method="post">
      <input type="hidden" name="operation" value="optiondelete"/>
      <input type="hidden" name="id"        value="<%=c1.getOpId()%>" >
      <input type="hidden" name="name"      value="<%=c1.getOpName()%>" >
  
      <td><button class="btn btn-danger" >Remove </button></td>
      </form>
      </tr>
    <% }%>
  </tbody>
</table>
            
             </div>
    </div>  
  
    <div class="container admin">
                <!-- List Option Top Page -->
                <div class="container-fluid mt-3 text-center" >
                    <h1> List Choise </h1>
                </div>
                <!-- -->
                <div class="row mt-3">
            <table class="table">
             <thead class="thead-dark">
            <tr>
              <th scope="col">#Id</th>
              <th scope="col">Name</th>
              <th scope="col">Option Id</th>
              <th scope="col">People Voted </th>
              <th scope="col">Action</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
              <% for(Choices c1: listChoiceses2){ 
              int TotalVoted = daoChoices2.getNmbrVotedByIdOpt(c1.getChOpId());
              int nbrVoted =daoChoices2.getNmbrVotedChooice(c1.getChId());
                double rs= (nbrVoted * 100) / TotalVoted;
              %>
              <tr>

                  <!-- choice update -->
          <form action="SrvPanel" method="post">
                <input type="hidden" value="chupdate" name="operation"/>
                <input type="hidden" name="id" value="<%=c1.getChId()%>" >

              <th scope="row"><%=c1.getChId()%></th>
              <td><div class="form-group">
                    <input name="name" value="<%=c1.getChName()%>" type="text" required>
                 </div>  </td> 
              <td><%=c1.getChOpId()%></td>
              <td><%=c1.getChPrsntg()%>
                <div class="progress">
                    <div class="progress-bar bg-info" role="progressbar" style="width: <%=rs%>%;" aria-valuenow="<%=rs%>" aria-valuemin="0" aria-valuemax="100"><%=rs%>% </div>
                </div>
              </td>
              <td><button class="btn btn-primary" >Update </button></td>
              </form>

              <form action="SrvPanel" method="post">
              <input type="hidden" name="operation" value="chdelete"/>
              <input type="hidden" name="id"        value="<%=c1.getChId()%>" >
              <input type="hidden" name="name"      value="<%=c1.getChName()%>" >

              <td><button class="btn btn-danger" >Remove </button></td>
              </form>
              </tr>
            <% }%>
          </tbody>
        </table>
            
             </div>
    </div>  
   <div class="container admin">
        <!-- List Users Top Page -->
        <div class="container-fluid mt-3 text-center" >
            <h1> List Options </h1>
        </div>
        <!-- -->
        <div class="row mt-3">
    <table class="table">
     <thead class="thead-dark">
    <tr>
      <th scope="col">#Id</th>
      <th scope="col">Name</th>
      <th scope="col">Family</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
      <th scope="col">Phone</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
      <% for(Users c1: listUser2){  %>
      <tr>
        
        
         
          <th scope="row"><%=c1.getUserId()%></th>
      <td><%=c1.getUserName()%></td>
      <td><%=c1.getUserFamily()%></td>
      <td><%=c1.getUserEmail()%></td>
      <td><%=c1.getUserPassword()%></td>
      <td><%=c1.getUserPhone()%></td>
     
  
      <form action="SrvPanel" method="post">
      <input type="hidden" name="operation" value="userdelete"/>
      <input type="hidden" name="id"        value="<%=c1.getUserId()%>" >
      <input type="hidden" name="name"      value="<%=c1.getUserName()%>" >
  
      <td><button class="btn btn-danger" >Remove </button></td>
      </form>
      </tr>
    <% }%>
  </tbody>
</table>
            
             </div>
    </div>  
  
  
</div>  
  
