<%--
  Created by IntelliJ IDEA.
  User: sy_zh
  Date: 2019/8/14
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h1>index</h1>
    <br/>
    <h3>原始文件上传</h3>
    <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传" />
    </form>
    <hr/>
    <h3>SpringMVC文件上传</h3>
    <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传" />
    </form>
    <hr/>
    <h3>跨服务器文件上传</h3>
    <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传" />
    </form>
</body>
</html>
