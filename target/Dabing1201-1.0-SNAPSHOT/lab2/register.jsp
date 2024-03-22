<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/20/2023
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>User Registration</h1>
<form method="post" action="register.jsp"><!--action to link jsp  to servlet -->
    Username <input type="text" name="username"/><br/>
    password <input type="password" name="password"/><br/>
    Email <input type="text" name="email"/><br/>

    Gender <input type="radio" name="gender" value="male">male <input type="radio" name="gender" value="female">Female
    <br/>
    Birth Date <input type="text" name="birthDate"/>(yyyy-mm-dd)<br/>
    <input type="submit" value="Register"/>

</form>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<c:if test="${! empty param.username }">

</c:if>
    <sql:setDataSource var="myDB" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                       url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false"
                       user="sa" password="admin123456789"/>
    <sql:query var="rs" dataSource="${myDB}">
        select * from usertable
    </sql:query>
    <table border="1">
        <c:forEach var="r" items="${rs.rows}">
            <tr>
                <td><c:out value="${r.id}"/></td>
                <td><c:out value="${r.username}"/></td>
                <td><c:out value="${r.password}"/></td>
                <td><c:out value="${r.email}"/></td>
                <td><c:out value="${r.gender}"/></td>
                <td><c:out value="${r.birthdate}"/></td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
