<%@ page import="com.dabing.week11.Person" %>
<%@ page import="com.dabing.week11.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/5/2023
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo #2</title>
</head>
<body>
<%
    //create person and dog
    Person person = new Person();
    person.setName("TOM");

    Dog dog = new Dog();
    dog.setName("TOMMY");

    person.setDog(dog);

    //set as attribute
    pageContext.setAttribute("pAtt", person);
    //like LoginServlet in MVC code


%>
<h1>Get person dog name - using java code</h1>
<h2> Person Name :
    <%
        Person p = (Person) pageContext.findAttribute("pAtt");
//print
        out.print(p.getName());
    %>

</h2>
<h2> Person Dog Name :<%=p.getDog().getName()%>
</h2>
<h1>Get person dog name - using EL code</h1>
<h2> Person Name :${pAtt.name}</h2>
<h2> Person Dog Name :${pAtt.dog.name}</h2>

<h1>Use [] --> give you more +array and list</h1>
<h2>Person name : ${pAtt["name"]}</h2>
</body>
</html>
