<%--
    Document   : index
    Created on : Mar 8, 2019, 10:56:10 AM
    Author     : evolu
--%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<jsp:useBean id="student" class="registrarbeans.Student" scope="session" />--%>
 <%--<jsp:setProperty name="student" property="*" />--%>  
<!DOCTYPE html>
<html>
    <f:view>
        <head>
            <!-- Global site tag (gtag.js) - Google Analytics -->
            <script async src="https://www.googletagmanager.com/gtag/js?id=UA-138903204-1"></script>
            <script>
                window.dataLayer = window.dataLayer || [];
                function gtag(){dataLayer.push(arguments);}
                gtag('js', new Date());

                gtag('config', 'UA-138903204-1');
            </script>
            
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>        
        </head>

        <body>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="Style.css" />
            <ul>
                <li><a class="" href="index.jsp"><i class="fa fa-fw fa-home"></i>Home</a></li>
                <li><a class="" href="search.jsp"><i class="fa fa-fw fa-search"></i>Search</a></li>
                <li><a class="" href="userdetailAll.jsp"><i class="fa fa-fw fa-drivers-license"></i>User Detail</a></li>
                <li><a class="" href="devicedetailAll.jsp"><i class="fa fa-fw fa-print"></i>Device Detail</a></li>
                <li><a class="" href="deviceOwner.jsp"><i class="fa fa-fw fa-building-o"></i>Device Owner</a></li>
                <li style="float:right"><a class="active" href="login.jsp"><i class="fa fa-fw fa-user"></i> LogIn</a></li>
                <li style="float:right"><a class="" href="signup.jsp"><i class="fa fa-fw fa-book"></i>SignUp</a></li>
</ul>
            <div>
                <h:form>
                    <div align="center">
                        <h:graphicImage value="img/LogoLogin.png" width="250px" height="250px" style="background: white"/>
                        <h1>Sign in</h1>
                        
                        Username : <h:inputText value="#{loginBean.username}"></h:inputText><br><br>
                        Password : <h:inputSecret value="#{loginBean.password}"/><br>
                        ${loginBean.errorMessage}
                        <br><h:commandButton value="Login" action="#{loginBean.validatLogin()}"></h:commandButton>
                            <%--<h:commandButton action="signup?faces-redirect=true" value="signup" />--%>
                    </div>
                    <!--<div align="right">-->
                        <%--<h:commandButton action="search?faces-redirect=true" value="back" />--%>
                    <!--</div>-->
                </h:form>
                <h2>${LoginBean.validatLogin}</h2>
            </div>
        </body>
    </f:view>
    </html>
