<%--
  Created by IntelliJ IDEA.
  User: Gene
  Date: 2017/12/12
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<script src="<c:out value="${path}"/>/js/jquery-1.7.2.js"></script>--%>


<html>
<script src="/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(function(){
        alert("a");
        var v="${msg}";
        alert("a");
        if(v.length!=0){
            alert(v);
            location.href="/configs-web/jsp/webconf/login.jsp";
        }
    });
    function submit() {
        $("loginForm").submit();
    }
</script>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<form id="loginForm" action="/login" method="post">
    用户名:<input type="text" name="name">
    密码  :<input type="password" name="password">
    <input type="button" value="login" onclick="submit()">
</form>




  </body>
</html>
