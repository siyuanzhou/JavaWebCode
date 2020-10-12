<%--
  Created by IntelliJ IDEA.
  User: sy_zh
  Date: 2019/8/13
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>传参数</title>
</head>
<body>
    <h3>传参数</h3>
    <a href="${pageContext.request.contextPath}/param/testParam?username=zsy&password=123">入门程序</a><br/>
    <a href="param/testParam?username=zsy&password=123">入门程序</a><br/>
    <a href="param/getAPI?username=zsy&password=123">获取原生API</a><br/>


    把数据封装Account类中<br/>
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>
        用户姓名：<input type="text" name="user.uname" /><br/>
        用户年龄：<input type="text" name="user.age" /><br/>
        <input type="submit" value="提交" />
    </form>

    自定义类型转换器<br/>
    <form action="param/saveUser" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        用户生日：<input type="text" name="date" /><br/>
        <input type="submit" value="提交" />
    </form>

</body>
</html>
