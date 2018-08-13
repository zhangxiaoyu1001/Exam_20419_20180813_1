
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
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

<form action="add" method="post">
    <table>
        <tr>
            <td>title</td>
            <td><input type="text" name="title" id="i" value="title"></td>
        </tr>
        <tr>
            <td>description</td>
            <td><textarea name="description" ></textarea></td>
        </tr>
        <tr>
            <td>language</td>
            <td><select name="language">
                <option value="1">English</option>
                <option value="2">Italian</option>
                <option value="3">Japanese</option>
                <option value="4">Mandarin</option>
                <option value="5">French</option>
                <option value="6">German</option>
            </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
