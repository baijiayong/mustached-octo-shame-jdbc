<%@ page pageEncoding="UTF-8" contentType="text/html;charSet=UTF-8"%>
<%@ page import="com.bodejidi.Member"%>
<%
Member member = (Member) request.getAttribute("member");
%>

<html>
    <head>
        <title>更新会员</title>
    </head>
    <body>
        <h1>更新会员</h1>
        <%@ include file="logout.jsp"%>
        <p>Update <%=member.getFirstName()%> <%=member.getLastName()%> Success</p>
        <a href="member?action=list">Member List</a>
    </body>
</html>