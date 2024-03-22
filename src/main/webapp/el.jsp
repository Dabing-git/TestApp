<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/5/2023
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>el demo #1</title>
</head>
<body>
<%
    //java code
    //set att in 4 scopes- page , request, session,application
    //pageContext.setAttribute("attName","in page");
    request.setAttribute("attName", "in request");
    session.setAttribute("attName", "in session");
    application.setAttribute("attName", "in application");

%>
<h1>Get att from 4 scopes</h1>

Att value :<%=pageContext.getAttribute("attName")%><br>
Att value :<%=request.getAttribute("attName")%><br>
Att value :<%=session.getAttribute("attName")%><br>
Att value :<%=application.getAttribute("attName")%><br>

<h1>Find attribute(not get) --search in page-->request-->session-->application-->give null(not in anyone)</h1>
Att value :<%=pageContext.findAttribute("attName")%><!-- which one?-->
<h1>EL Code example</h1>
:${x}<!--guess?a. null , b.x , c. error d. nothing--><br>
att :${attName}<!-- pageContext.findAttribute("attName")-->
<h1>use [] in el </h1>
<h2> Person name :</h2>
${(5*5) ne 25}
</body>
</html>
