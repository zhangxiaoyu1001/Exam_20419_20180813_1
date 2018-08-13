<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Film" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: xiaoyu
  Date: 2018/8/13
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>showFilms</title>
</head>
<body>

<form action="Film" method="post">
    <h1>Films显示页面</h1>

    <hr/>

    <table>

        <tr>
            <th> Film_id</th>
            <th> Title</th>
            <th> Description</th>
            <th> Language</th>
        </tr>

        <c:forEach items="${film_list}" var="film">
            <tr>
                <td>${film.film_id}</td>
                <td>${film.title}</td>
                <td>${film.description}</td>
                <td>${film.name}</td>
            </tr>
        </c:forEach>

    </table>
</form>

<br>
<a href="add.jsp">Add</a>

</body>
</html>
