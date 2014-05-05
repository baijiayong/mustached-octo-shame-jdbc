<%@ page pageEncoding="UTF-8" contentType="text/html;charSet=UTF-8"%>
<%@ page import="com.bodejidi.Member"%>
<%
Member member = (Member) request.getAttribute("member");
%>

<html>
    <head>
        <title>显示会员</title>
    </head>
    <body>
        <form action="member" method="POST">
            <h1>显示会员</h1>
            <%@ include file="logout.jsp"%>
            <table>
                <tr>
                    <td>Id:</td>
                    <td><%=member.getId()%></td>
                </tr>
                <tr>
                    <td>FirstName:</td>
                    <td><input type="text" name="firstName" value="<%=member.getFirstName()%>"></td>
                </tr>
                <tr>
                    <td>LastName:</td>
                    <td><input type="text" name="lastName" value="<%=member.getLastName()%>"></td>
                </tr>
            </table>
            <input type="hidden" name="id" value="<%=member.getId()%>"/>
            <input type="submit" name="action" value="Delete"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>