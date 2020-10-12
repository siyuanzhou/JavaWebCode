<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/a.js"></script>
</head>
<body>
<h3>入門程序</h3>
<a href="hello">入门程序</a>

<!-- request body 注解 -->
<form action="useRequestBody" method="post">
    用户名称：<input type="text" name="username" ><br/>
    用户密码：<input type="password" name="password" ><br/>
    用户年龄：<input type="text" name="age" ><br/>
    <input type="submit" value=" 保存 ">
</form>

<a href="updateUser?name=test">测试 modelattribute</a>

<!-- SessionAttribute 注解的使用 -->
<a href="user/user">存入 SessionAttribute</a>
<a href="user/find">取出 SessionAttribute</a>
<a href="user/delete">清除 SessionAttribute</a>
<hr/>
<script src="js/jquery.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url:"testAjax",
                contentType:"application/json;charset=UTF-8",
                data:'{"name":"zsy","password":"123"}',
                datatype:"json",
                type:"post",
                success:function (data) {
                    alert(data);
                    alert(data.name);
                }
            });
        });
    });
</script>
<button id="btn">发送ajax请求</button>
</body>
</html>

