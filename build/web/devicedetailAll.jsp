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
        <title>JSP Page</title> 
    </head>
        <body> 
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="Style.css" />
            <ul>
                <li><a class="" href="index.jsp"><i class="fa fa-fw fa-home"></i>Home</a></li>
                <li><a class="" href="search.jsp"><i class="fa fa-fw fa-search"></i>Search</a></li>
                <li><a class="" href="userdetailAll.jsp"><i class="fa fa-fw fa-drivers-license"></i>User Detail</a></li>
                <li><a class="active" href="devicedetailAll.jsp"><i class="fa fa-fw fa-print"></i>Device Detail</a></li>
                <li><a class="" href="deviceOwner.jsp"><i class="fa fa-fw fa-building-o"></i>Device Owner</a></li>
                <li style="float:right"><a class="" href="login.jsp"><i class="fa fa-fw fa-user"></i> LogIn</a></li>
                <li style="float:right"><a class="" href="signup.jsp"><i class="fa fa-fw fa-book"></i>SignUp</a></li>
            </ul>
        <h:form>
            <%--<h:graphicImage value="img/devicedetail.jpg"/>--%>
        <div align="center">
            <h2>Device Detail</h2>
        <table border="1" cellpadding="20">
            
                    <%-- <caption><h2>Hello user : ${userDetailBean.equipList.get(0).name}</h2></caption> --%>

                    <tr>
                <th>ID</th> 
                <th>Type</th>
                <th>Brand</th>
                <th>Model</th>
                <th>SerialNo</th>
                <th>Employee No</th>
            </tr>
            <c:forEach var="equipment" items="${devicedetailallBean.equipList}" >
                <tr>
                    <td>${equipment.id}</td>
                    <td>${equipment.type}</td>
                    <td>${equipment.brand}</td>
                    <td>${equipment.model}</td>
                    <td>${equipment.serialNo}</td>
                    <td>${equipment.empNo}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
        </h:form>
    </body>  
    </f:view>
    
</html>
