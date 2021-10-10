<%--
    Document   : index
    Created on : Mar 8, 2019, 10:56:10 AM
    Author     : evolu
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <title>Search</title>
            <script>
                function doSearchDetail(empno){
                    document.getElementById("searchForm:empno").value = empno;
                    document.getElementById("searchForm:empno").value;
                    document.getElementById("searchForm:searchDetail").click();
                }
            </script>

            <script language="javascript">
                function validate() {
                    var sempNo = document.getElementById("searchForm:sempNo");
                    var semail = document.getElementById("searchForm:semail");
                    var sserial = document.getElementById("searchForm:sserial");
                    var stype = document.getElementById("searchForm:stype");
                    var sbrand = document.getElementById("searchForm:sbrand");
                    
                    if ( sempNo.value == "" && semail.value == "" && sserial.value == "" && stype.value == "0" && sbrand.value == "0" 
                       )
                    {
                        alert("Please fill in the information!");
                        return false;
                    }
                    return true;
                }
            </script>  
        </head>
        <body>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="Style.css" />
            <ul>
                <li><a class="" href="index.jsp"><i class="fa fa-fw fa-home"></i>Home</a></li>
                <li><a class="active" href="search.jsp"><i class="fa fa-fw fa-search"></i>Search</a></li>
                <li><a class="" href="userdetailAll.jsp"><i class="fa fa-fw fa-drivers-license"></i>User Detail</a></li>
                <li><a class="" href="devicedetailAll.jsp"><i class="fa fa-fw fa-print"></i>Device Detail</a></li>
                <li><a class="" href="deviceOwner.jsp"><i class="fa fa-fw fa-building-o"></i>Device Owner</a></li>
                <li style="float:right"><a class="" href="login.jsp"><i class="fa fa-fw fa-user"></i> LogIn</a></li>
                <li style="float:right"><a class="" href="signup.jsp"><i class="fa fa-fw fa-book"></i>SignUp</a></li>
            </ul>
            <div>
                <h:form id="searchForm" onsubmit="return validate()">
                    <div align="right">
                        <br>
                    </div>
                    
                    <div align="center">
                        <h2>Search data</h2>
                        <table border="1" cellpadding="20">
                            <div>
                                <br><br>
                                Employee No : <h:inputText id="sempNo" value="#{searchBean.sempNo}"></h:inputText>
                                E-mail : <h:inputText id="semail" value="#{searchBean.semail}"></h:inputText>
                                Serial : <h:inputText id="sserial" value="#{searchBean.sserial}"></h:inputText>
                                Type : <h:selectOneMenu id="stype" value="#{searchBean.stype}">
                                        <f:selectItem itemValue="0" itemLabel="--select--" />
                                        <f:selectItem itemValue="PC" itemLabel="PC" />
                                        <f:selectItem itemValue="Notebook" itemLabel="Notebook" />
                                        <f:selectItem itemValue="Monitor" itemLabel="Monitor" />
                                        <f:selectItem itemValue="Keyboard" itemLabel="Keyboard" />
                                        <f:selectItem itemValue="Mouse" itemLabel="Mouse" />
                                        <f:selectItem itemValue="Macbook" itemLabel="Macbook" />
                                </h:selectOneMenu>
                                        Brand : <h:selectOneMenu id="sbrand" value="#{searchBean.sbrand}">
                                        <f:selectItem itemValue="0" itemLabel="--select--" />
                                        <f:selectItem itemValue="ASUS" itemLabel="ASUS" />
                                        <f:selectItem itemValue="LENOVO" itemLabel="LENOVO" />
                                        <f:selectItem itemValue="IBM" itemLabel="IBM" />
                                        <f:selectItem itemValue="SAMSUNG" itemLabel="SAMSUNG" />
                                        <f:selectItem itemValue="DELL" itemLabel="DELL" />
                                        <f:selectItem itemValue="PHILIPS" itemLabel="PHILIPS" />
                                        <f:selectItem itemValue="LG" itemLabel="LG" />
                                        <f:selectItem itemValue="HP" itemLabel="HP" />
                                        <f:selectItem itemValue="MICROSOFT" itemLabel="MICROSOFT" />
                                        <f:selectItem itemValue="LOGITECH" itemLabel="LOGITECH" />
                                        <f:selectItem itemValue="APPLE" itemLabel="APPLE" />
                                </h:selectOneMenu> 
                                <br><br>
                                <h:commandButton action="#{searchBean.validatSearch()}" value="Search" ></h:commandButton>
                                <br>${searchBean.errorMessage}
                            </div>                   
                            <tr bgcolor="#d9d9d9">
                                <br><br>
                                <th>name</th>
                                <th>nickName</th>
                                <th>empNo</th>
                            </tr>
                            <c:forEach var="result" items="${searchBean.searchResult}" >
                                <tr>
                                    <td><p onclick="doSearchDetail('${result.empNo}')"><U>${result.name}</p> </td>
                                    <td>${result.nickName}</td>
                                    <td>${result.empNo}</td>
                                </tr>
                            </c:forEach>
                                
                            <h:inputHidden id="empno" value="#{searchBean.empno}" ></h:inputHidden>
                            <h:commandButton id="searchDetail" style="display:none" value="" action="#{searchBean.doSearchDetail()}" ></h:commandButton>
                        </table>
                    </div>
                    
                </h:form>
            </div>
        </body>
    </f:view>
</html>
