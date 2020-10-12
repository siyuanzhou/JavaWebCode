<%--
  Created by IntelliJ IDEA.
  User: sy_zh
  Date: 2019/8/13
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Anno常用注解</title>
</head>
<body>
    <a href="anno/requestParam?username=哈哈">requestParam</a>
    <br>
    <form action="anno/requestBody" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        <input type="submit" >
    </form>
    <br>
    <a href="anno/PathVariable/10">PathVariable</a>
    <a href="anno/requestHeader">requestHeader</a>
    <a href="anno/cookieValue">cookieValue</a>

    <br>
    <form action="anno/modelAttribute" method="post">
        姓名：<input type="text" name="uname" /><br/>
        年龄：<input type="text" name="age" /><br/>
        <input type="submit" >
    </form>
</body>
</html>
