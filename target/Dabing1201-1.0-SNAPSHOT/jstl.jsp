<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/19/2023
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- use jstl core tag, add lib-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>jstl demo</title>
</head>
<body>
<%
    /*
if username == null
    print Guest
 else
     print username
*/
    //session.setAttribute("username","Admin");
%>
<c:set var="username" value="Admin" scope="session"/>
<c:set var="password" value="123" scope="request"/>
<br>Password (before remove):${password}
<c:remove var="password" scope="request"/>
<br>Password (after remove):${password}

<h1>Welcome , <c:out value="${username}" default="Guest"/> </h1>


<h1>Use c:forEach to print 1 to 10</h1>
<c:forEach var="i" begin="1" end="10" step="1">
    <ul>
        <li>${i}</li>
    </ul>
</c:forEach>
<h1>print 1,3,5,7,9</h1>
<c:forEach var="i" begin="1" end="10" step="2">
    <ul>
        <li>${i}</li>
    </ul>
</c:forEach>

<h1> User c:forEach to get items from an Array</h1>
<%
//array
    String[] firstName={"Da","Tom","poll"};
    //must set attribute
    request.setAttribute("firstName",firstName);

    //list
    ArrayList<String> lastName=new ArrayList<>();
    lastName.add("Bing");
    lastName.add("Lee");
    lastName.add("Zhang");
    request.setAttribute("lName",lastName);

%>
<c:forEach var="f" items="${firstName}">
    <ul><li>${f}</li></ul>
</c:forEach>
<h1>Use c:forEach to get items from arraylist</h1>
<c:forEach var="f" items="${lName}">
    <ul><li>${f}</li></ul>
</c:forEach>
<h1>Use c:forTokens</h1>
<c:forTokens var="t" items="one,two,three,four.five.six" delims=",.">
    <ul><li>${t}</li></ul>
</c:forTokens>
<c:catch var="msg">
<%

int i=10/0;//exception
%>
</c:catch>
Message : ${msg}
</body>
</html>
