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
        <script>
            function doEditUser(empno){
//                alert("EditUser : "+empno);
                document.getElementById("userDetailForm:edituserempno").value = empno;
                document.getElementById("userDetailForm:edituserempno").value;
                document.getElementById("userDetailForm:edituser").click();
            }
        </script>
        
        <script>
            function doDeleteData(empno){
//                alert("Delete "+empno);
                document.getElementById("userDetailForm:deleteempno").value = empno;
                document.getElementById("userDetailForm:deleteempno").value;
                document.getElementById("userDetailForm:delete").click();
            }
        </script>
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
                <li style="float:right"><a class="active" href="manageuser.jsp"><i class="fa fa-fw fa-book"></i>Manage User</a></li>
            </ul>
        <h:form id="userDetailForm">
            <%--<h:graphicImage value="img/userdetail.jpg"/>--%>
        <div align="center">
            <h2>Manage User</h2>
        <table border="1" cellpadding="20">
            
                    <%-- <caption><h2>Hello user : ${manageuserBean.equipList.get(0).name}</h2></caption> --%>

                    <tr>
                        <th>ID</th>
                        <th>Employee No</th>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Nickname</th>
                        <th>E-mail</th>
                        <th>TelNo</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Edit</th>
                        <th>Delete</th><%--
                        <th>TelIn</th>
                        <th>Building</th>
                        <th>Floor</th>
                        <th>Room</th>
<th>Extension No</th> --%>
                        
                    </tr>
                    <c:forEach var="user" items="${manageuserBean.userList}" >
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.empNo}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.nickName}</td>
                            <td>${user.email}</td>
                            <td>${user.telNo}</td> <%--
                            <td>${user.telIn}</td> 
                            <td>${user.building}</td>
                            <td>${user.floor}</td>
                            <td>${user.room}</td>
<td>${user.tableNo}</td> --%>
                            <td>${user.userName}</td>
                            <td>${user.passWord}</td>
                            <td><a onclick="doEditUser('${user.empNo}')" image="ic_border_color_black_48dp.png" ><img src="img/icon/ic_border_color_black_48dp.png" height="20" width="20"></a> </td>
                            <td><a onclick="doDeleteData('${user.id}')" image="ic_delete_black_48dp.png" ><img src="img/icon/ic_delete_black_48dp.png" height="20" width="20"></a> </td>
                        </tr>
                    </c:forEach>
                        
                    <!--edit user-->
                    <h:inputHidden id="edituserempno" value="#{manageuserBean.edituser}" ></h:inputHidden>
                    <h:commandButton id="edituser" style="display:none" value="" action="#{manageuserBean.doEditUser()}" ></h:commandButton>
                    <!--delete User-->
                    <h:inputHidden id="deleteempno" value="#{manageuserBean.id}" ></h:inputHidden>
                    <h:commandButton id="delete" style="display:none" value="" action="#{manageuserBean.doDeleteData()}" ></h:commandButton>     
        </table>
    </div>
        </h:form>
    </body>  
    </f:view>
    
</html>
