<%@ page pageEncoding="UTF-8" contentType="text/html;charSet=UTF-8"%>

<html>
    <head>
        <title>登录</title>
    </head>
    <body>
        <h1>登录</h1>
        <form action="login" method="POST">
            <label>用户名：<input type="text" name="username"/></label>
            <label>密码：<input type="password" name="password"/></label>
            <input type="submit" name="action" value="login"/>
        </form>
    </body>
</html>
