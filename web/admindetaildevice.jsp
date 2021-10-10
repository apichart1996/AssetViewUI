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
            function doEditData(empno){
//                alert("Edit : "+empno);
                document.getElementById("userDetailForm:editempno").value = empno;
                document.getElementById("userDetailForm:editempno").value;
                document.getElementById("userDetailForm:edit").click();
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
        
        <script>
            function doEditUser(empno){
//                alert("EditUser : "+empno);
                document.getElementById("userDetailForm:edituserempno").value = empno;
                document.getElementById("userDetailForm:edituserempno").value;
                document.getElementById("userDetailForm:edituser").click();
            }
        </script>
        <style>
            .button {
                background: white url('editicon.jpg') no-repeat top;
            }
        </style>
            
            <script async src="https://www.googletagmanager.com/gtag/js?id=UA-138903204-1"></script>
            <script>
                window.dataLayer = window.dataLayer || [];
                function gtag(){dataLayer.push(arguments);}
                gtag('js', new Date());

                gtag('config', 'UA-138903204-1');
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
                <li style="float:right"><a class="" href="manageuser.jsp"><i class="fa fa-fw fa-book"></i>Manage User</a></li>
            </ul>
        <h:form id="userDetailForm">
            <%--<h:graphicImage value="img/devicedetail.jpg"/>--%>
        <div align="center">
            <h2>Detail Device Admin</h2>
        <table border="1" cellpadding="20">
            
            <caption><h2>ยินดีต้อนรับ<p onclick="doEditUser('${admindetaildeviceBean.empno}')"><U>${admindetaildeviceBean.equipList.get(0).name}</p></h2></caption>
            
            <tr>
                <th>Type</th>
                <th>Brand</th>
                <th>Model</th>
                <th>SerialNo</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="equipment" items="${admindetaildeviceBean.equipList}" >
                <tr>
                    <td>${equipment.type}</td>
                    <td>${equipment.brand}</td>
                    <td>${equipment.model}</td>
                    <td>${equipment.serialno}</td>
                    <td><a onclick="doEditData('${equipment.id}')" image="ic_border_color_black_48dp.png" ><img src="img/icon/ic_border_color_black_48dp.png" height="20" width="20"></a> </td>
                    <td><a onclick="doDeleteData('${equipment.id}')" image="ic_delete_black_48dp.png" ><img src="img/icon/ic_delete_black_48dp.png" height="20" width="20"></a> </td>
                    
                </tr>
            </c:forEach>
                <!--edit device-->
                   <h:inputHidden id="editempno" value="#{admindetaildeviceBean.id}" ></h:inputHidden>
                   <h:commandButton id="edit" style="display:none" value="" action="#{admindetaildeviceBean.doEditData()}" ></h:commandButton>
                <!--edit user-->
                   <h:inputHidden id="edituserempno" value="#{admindetaildeviceBean.edituser}" ></h:inputHidden>
                   <h:commandButton id="edituser" style="display:none" value="" action="#{admindetaildeviceBean.doEditUser()}" ></h:commandButton>
                <!--delete device-->
                   <h:inputHidden id="deleteempno" value="#{admindetaildeviceBean.empno}" ></h:inputHidden>
                   <h:commandButton id="delete" style="display:none" value="" action="#{admindetaildeviceBean.doDeleteData()}" ></h:commandButton>     
        </table>
        <h:commandButton action="adddeviceadmin?faces-redirect=true" value="Add device" />
    </div>
        </h:form>
    </body>  
    </f:view>
    
</html>
