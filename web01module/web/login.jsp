<%--
  Created by IntelliJ IDEA.
  User: cjw
  Date: 2017/4/7
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <div align="center">
        <form action="hello" method="post">
            <input type="text" name="userBean.userId">
            <input type="password" name="userBean.passWord">
            <input type="submit" value="提交">
        </form>
    </div>
</head>
<body>

</body>
</html>
