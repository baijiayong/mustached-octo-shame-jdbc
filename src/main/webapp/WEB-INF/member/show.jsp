<%@ page pageEncoding="UTF-8" contentType="text/html;charSet=UTF-8"%>
<%@ page import="java.util.List,com.bodejidi.Member"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<Member> memberList = (List<Member>) request.getAttribute("memberList");
%>
<html>
    <head>
        <title>会员列表</title>
    </head>
    <body>
        <h1>会员列表</h1>
        <form action="member" method="POST">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>FirstName</td>
                    <td>LastName</td>
                </tr>
                <c:forEach var="member" items="${memberList}"> 
                <tr>
                    <td><a href="?action=show&id=${member.id}">${member.id}</a></td>
                    <td>${member.firstName}</td>
                    <td>${member.lastName}</td>
                </tr>
                </c:forEach>
            </table>
            <p><a href=".">Add Member</a></p>
        </form>
    </body>
</html>