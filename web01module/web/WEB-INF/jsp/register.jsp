<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/4/9
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <div align="center">
        <form action="hello.do" method="post">
            <input type="hidden" name="type" value="register">
            <input type="text" name="userBean.userId">
            <input type="password" name="userBean.passWord">
            <input type="submit" value="提交">
        </form>
    </div>
</head>
<body>

</body>
</html>
