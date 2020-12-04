<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8,ISO-8859-1">
        <title>User Login</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">

                    <div class="card mt-3">

                        <div class="card-header custom-bg text-white">
                            <h3>Вход</h3>
                        </div>
                        <div class="card-body">

                            <%@include file="components/message.jsp" %>

                            <form action="SrvLogin" method="post">
                                <div class="form-group">
                                    <label >Email</label>
                                    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                                </div>

                                <div class="form-group">
                                    <label >пароль</label>
                                    <input name="password" type="password" class="form-control" id="exampleInputPassword1" required>
                                </div>
                                <a href="regestire.jsp" class="text-center d-block mb-3">
                                    Регистрация !
                                </a>

                                <div class="container text-center"> 
                                    <button type="submit" class="btn btn-primary custom-bg border-0">Войти</button>
                                    <button type="reset" class="btn btn-primary custom-bg border-0">Отмена</button>
                                </div>
                            </form>
                        </div>

                    </div>


                </div>
            </div>
        </div>

    </body>
</html>
