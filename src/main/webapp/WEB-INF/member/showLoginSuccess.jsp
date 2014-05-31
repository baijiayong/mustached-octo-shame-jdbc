<%@ page pageEncoding="UTF-8" contentType="text/html;charSet=UTF-8"%>

<html>
    <head>
        <title>登录成功</title>
    </head>
    <body>
        <h1>Login Success</h1>
        <%@ include file="logout.jsp"%>
        <p>please click <a href="<%=request.getContextPath() + "/auth/login"%>">here</a> to return to the memberlist!</p>
    </body>
</html>