<%@ page import="domain.Result" %><%--
  Created by IntelliJ IDEA.
  User: DEll
  Date: 11/27/2021
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<% Result result = (Result) request.getAttribute("result");
%>
<%  if (result!=null){    %>

<h4><%=result.getExplanation()%></h4>
<%

}%>
<% if (result==null){%>
<h4>Your result does not match the norm.</h4>
<%}%>
</body>
</html>
