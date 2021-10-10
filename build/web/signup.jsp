<%-- 
    Document   : userDetail
    Created on : Mar 8, 2019, 3:24:15 PM
    Author     : evolu
--%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <title>Welcome to Webservice</title>
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
                <li style="float:right"><a class="" href="login.jsp"><i class="fa fa-fw fa-user"></i> LogIn</a></li>
                <li style="float:right"><a class="active" href="signup.jsp"><i class="fa fa-fw fa-book"></i>SignUp</a></li>
</ul>
            <h:form>
                <div>
                    <div align="center">
                        <h2>Sign Up</h2>
                    <table>
                        Firstname : <h:inputText value="#{signupBean.firstName}"></h:inputText>
                        Lastname : <h:inputText value="#{signupBean.lastName}"></h:inputText><br>
                        Nickname : <h:inputText value="#{signupBean.nickName}"></h:inputText>
                        Employee No : <h:inputText value="#{signupBean.empNo}"></h:inputText><br>
                        Tel In : <h:inputText value="#{signupBean.telIn}"></h:inputText>
                        Tel No : <h:inputText value="#{signupBean.telNo}"></h:inputText><br>
                        E-mail : <h:inputText value="#{signupBean.email}"></h:inputText>
                        Building : <h:inputText value="#{signupBean.building}"></h:inputText><br>
                        floor : <h:inputText value="#{signupBean.floor}"></h:inputText>
                        Room : <h:inputText value="#{signupBean.room}"></h:inputText><br>
                        Extension No : <h:inputText value="#{signupBean.tableNo}"></h:inputText>
                        Username : <h:inputText value="#{signupBean.userName}"></h:inputText><br>
                        Password : <h:inputSecret id="pass" value="#{signupBean.passWord}"/><br>
                        <br><h:commandButton value="Submit" action="#{signupBean.validatSignup()}"></h:commandButton>
                        <br>${signupBean.errorMessage}
                    </table>
                    </div>
                </div>
            </h:form>
        </body>  
    </f:view>
</html>
