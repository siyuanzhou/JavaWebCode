
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <b>查询了所有的账户信息</b><br>
    <c:forEach items="${list}" var="account">
        ${account.name}<br>
    </c:forEach>
</body>
</html>
