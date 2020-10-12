<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2020/2/23
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发送请求</title>
</head>
<body>
<h1>欢迎页</h1>
<form action="${pageContext.request.contextPath}/succ.jsp" method="post">
    <input type="text" name="name"><br>
    <input type="password" name="pwd"><br>
    <input type="submit" value="提交"><br>
</form>
</body>

</html>