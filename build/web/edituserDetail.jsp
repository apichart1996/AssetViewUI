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
                        <h2>Edit User Detail</h2>
                        <table border="1" cellpadding="20">
                            <tr>
                                <!--<th>ID</th>-->
                                <th>empNo</th>
                                <th>firstName</th> 
                                <th>lastName</th>
                                <th>nickName</th>
                                <th>email</th>
                                <th>telIn</th>
                                <th>telNo</th>
                                <th>building</th>
                                <th>floor</th>
                                <th>room</th>
                                <th>userName</th>
                                <th>Extension No</th>
                                <!--<th>passWord</th>-->

                            </tr>
                            
                            
                            <c:forEach var="sign" items="${edituserdetailBean.signList}" >
                                <tr>
                                    <%--<td>${sign.id}</td>--%>
                                    <td>${sign.empNo}</td>
                                    <td>${sign.firstName}</td>
                                    <td>${sign.lastName}</td>
                                    <td>${sign.nickName}</td>
                                    <td>${sign.email}</td>
                                    <td>${sign.telIn}</td>
                                    <td>${sign.telNo}</td>
                                    <td>${sign.building}</td>
                                    <td>${sign.floor}</td>
                                    <td>${sign.room}</td>
                                    <td>${sign.userName}</td>
                                    <td>${sign.tableNo}</td>
                                    </tr>
                            </c:forEach>
                            
                        </table>
                        <h:commandButton action="add?faces-redirect=true" value="Add device" />
                    </div>
                </div>
                
<%--                <div align="right">
                    <h:commandButton action="index?faces-redirect=true" value="home" />
                    <h:commandButton action="signup?faces-redirect=true" value="back" />
                </div>--%>
            </h:form>
        </body>  
    </f:view>
</html>
