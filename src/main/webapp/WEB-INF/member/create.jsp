<%@ page pageEncoding="UTF-8" contentType="text/html;charSet=UTF-8"%>

<html>
    <head>
        <title>创建会员</title>
    </head>
    <body>
        <h1>创建会员</h1>
        <form action="member" method="POST">
            <label>FirstName: <input type="text" name="firstName"/></label>
            <label>LastName:<input type="text" name="lastName"/></label>
            <input type="submit" name="action" value="add"/>
        </form>
    </body>
</html>