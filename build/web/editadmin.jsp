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
                <li style="float:right"><a class="" href="signup.jsp"><i class="fa fa-fw fa-book"></i>SignUp</a></li>
            </ul>
            <h:form>
                <div>
                    <div align="center">
                        <%--<h:graphicImage value="img/edituser.jpg"/>--%>
                        <h2>Edit User</h2>
                    
                        <table border="1" cellpadding="20">
                            Firstname : <h:inputText value="#{editadminBean.firstName}"></h:inputText>
                            Lastname : <h:inputText value="#{editadminBean.lastName}"></h:inputText><br>
                            Nickname : <h:inputText value="#{editadminBean.nickName}"></h:inputText>
                            Employee No : <h:inputText value="#{editadminBean.empNo}"></h:inputText><br>
                            Tel In : <h:inputText value="#{editadminBean.telIn}"></h:inputText>
                            Tel No : <h:inputText value="#{editadminBean.telNo}"></h:inputText><br>
                            E-mail : <h:inputText value="#{editadminBean.email}"></h:inputText>
                            Building : <h:inputText value="#{editadminBean.building}"></h:inputText><br>
                            floor : <h:inputText value="#{editadminBean.floor}"></h:inputText>
                            Room : <h:inputText value="#{editadminBean.room}"></h:inputText><br>
                            Extension No : <h:inputText value="#{editadminBean.tableNo}"></h:inputText>
                            Username : <h:inputText value="#{editadminBean.userName}"></h:inputText><br>
                            Password : <h:inputText value="#{editadminBean.passWord}"></h:inputText>
                            <br><h:commandButton value="Submit" action="#{editadminBean.validatEdit()}"></h:commandButton>
                            <h:commandButton action="admindetaildevice?faces-redirect=true"value="back"></h:commandButton>
                            <br>${editadminBean.errorMessage}
                        </table>
                    </div>                       
                </div>                        
            </h:form>                        
        </body>                       
    </f:view>                       
</html>                       
                        
                                            
                    
                
            
          
    
