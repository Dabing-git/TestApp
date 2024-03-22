<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/9/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="CalServlet2" method="post">
    <table>
        <tr>
            <td>First Val :</td>
            <td><input type="text" name="firstVal"/></td>
            <td>Enter a Name:</td>
            <td><input type="text" name="name"/></td>
       </tr>
        <tr>
            <td>Second Val :</td>
            <td><input type="text" name="secondVal"/></td>
            <td>Length:</td>
            <td><input type="text" name="length"/></td>
        </tr>
        <tr>
            <td>Result :</td>
            <td><input type="text" name="result" value="${cookie.cResult.value}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><input type="submit" name="action" value="Add"/></td>
            <td><input type="submit" name="action" value="Subtract"/></td>
            <td><input type="submit" name="action" value="Multiply"/></td>
            <td><input type="submit" name="action" value="Divide"/></td>
            <td><input type="submit" name="action" value="Compute Length"/></td>
            <td><input type="submit" name="action" value="Reset"/></td>
        </tr>
    </table>
</form>

</body>
</html>
