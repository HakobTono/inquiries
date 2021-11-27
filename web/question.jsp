<%@ page import="java.util.List" %>
<%@ page import="domain.Question" %>
<%@ page import="domain.Answer" %>
<%@ page import="domain.Poll" %><%--
  Created by IntelliJ IDEA.
  User: DEll
  Date: 11/27/2021
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
</head>
<body>
<%
    List<Question> questions = (List<Question>) request.getAttribute("question");
    Poll poll = (Poll) request.getAttribute("poll");%>
<form action="/result">
<%
    for (Question question : questions) {
%>

    <p><%=question.getText()%></p>
    <input type="hidden"name="pollId" value="<%=poll.getId()%>">
    <%
        for (Answer answer: question.getAnswers()) {
      %>
    <p><input type="radio" name="<%=question.getId()%>" value="<%=answer.getWeight()%>"><%=answer.getText()%> </p>
    <%    }
    %>



<%}%>
    <input type="submit">
</form>
</body>
</html>
