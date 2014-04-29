<%@page pageEncoding="UTF-8" contentType="text/html;charSet=UTF-8"%>
<%@page import="com.bodejidi.Member"%>
<% Member member = (Member) request.getAttribute("member");%>
<html>
    <body>
        <p>Add <%=member.getFirstName()%><%=member.getLastName()%> Success!</p>
        <a href="?action=list">Member List</a>
    </body>
</html>