<%--
  Created by IntelliJ IDEA.
  User: 魏晨
  Date: 2022/3/24
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>hello</title>

</head>
<body>
my jsp page~~~
<%--  <h1 style="color: red;">黄河之水天上来，奔流到海不复回</h1>--%>
  <%
    System.out.println("jsp~~~");
  %>
  <%
    out.print("hello world");
    pageContext.setAttribute("msg","test~~~");
    pageContext.getAttribute("msg");
    System.out.println(pageContext.getAttribute("msg"));
  %>
  <%
     session.setAttribute("name","jack");
     session.setAttribute("age",20);
     request.setAttribute("name","tom");
  %>
