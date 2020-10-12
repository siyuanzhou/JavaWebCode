<%--
  Created by IntelliJ IDEA.
  User: sy_zh
  Date: 2019/8/13
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>response</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"zsy","password":"123","age":18}',
                    datatype:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                        alert(data.username);
                    }
                });
            });
        });


    </script>

</head>
<body>
    <a href="user/testString">返回值String</a>
    <a href="user/testVoid">返回值Void</a>
    <a href="user/testModelAndView">testModelAndView</a>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
    <br>
    <button id="btn">发送ajax请求</button>

</body>
</html>
