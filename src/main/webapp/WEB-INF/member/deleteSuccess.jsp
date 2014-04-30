<%@ page pageEncoding="UTF-8" contentType="text/html;charSet=UTF-8"%>
<%@ page import="com.bodejidi.Member"%>
<%
Member member = (Member) request.getAttribute("memberId");
%>

<html>
    <head>
        <title>删除成功</title>
    </head>
    <body>
        <h1>删除会员</h1>
        <p>Delete <%=member.getId()%> Success</p>
        <a href="member?action=list">Member List</a>
    </body>
</html>