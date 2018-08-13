<%--
  Created by IntelliJ IDEA.
  User: xiaoyu
  Date: 2018/8/13
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Login</title>
    <style type="text/css">
        h1{text-align:left;}
        h4{text-align:left;color:red;}
        body{background:url(images/1.png)}
        a{text-decoration:none;font-size:20px;color:black;}
        a:hover{text-decoration:underline;font-size:24px;color:red;}
    </style>
</head>
<body>

<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){
%>
    <script type="text/javascript">
        alert("<%=message%>");
    </script>
<%} %>

<form action="UserLogin" method="post">
    <h1>用户登陆页面</h1>

    <hr/>
    <table align="left">
        <tr>
            <td>账号：</td>
            <td><input type="text" name="firstName" id="firstName"></td>
        </tr>

        <tr>
            <td colspan="1">
            </td>
            <td>
                <input type="submit" value="登陆"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
