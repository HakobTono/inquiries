<%@ page import="java.util.List" %>
<%@ page import="domain.Poll" %><%--
  Created by IntelliJ IDEA.
  User: DEll
  Date: 11/24/2021
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%List<Poll> polls  = (List<Poll>) request.getAttribute("poll"); %>

    <% if (polls != null && !polls.isEmpty())
    {
        for (Poll poll : polls) {%>
         <a href="/question?id=<%=poll.getId()%>"><%=poll.getName()%></a><br>
        <%
        }
    }%>

</body>
</html>
