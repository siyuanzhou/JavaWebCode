<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2020/2/24
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
    <script>
        window.onload = function () {
            document.getElementById("check").onclick = function () {
                this.src = "/checkCode?time=" + new Date().getTime();
            }
        }
    </script>
    <style>
        div {
            color: red;
        }

    </style>
</head>
<body>
<form action="/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img src="/checkCode" id="check"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
<div><%=request.getAttribute("check_error") == null ? "" : request.getAttribute("check_error")%>
</div>
<div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %>
</div>

</body>
</html>
