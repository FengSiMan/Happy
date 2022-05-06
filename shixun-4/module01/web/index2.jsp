<%--
  Created by IntelliJ IDEA.
  User: wslashy
  Date: 2022/3/24
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>el运算符</h1>
${100+200}<br>
${100-200}<br>
${100/200}<br>
${100 div 400}<br>
${100 % 30}<br>
${100 mod 30}

${100==200}
${100>200}

<h2>逻辑运算符</h2>
${100>200 && 100>20}
${100>200 and 100>20}
<%
    out.print("hello world");
    pageContext.setAttribute("msg", "test~~~");
    pageContext.getAttribute("msg");
    System.out.println(pageContext.getAttribute("msg"));
%>
<%
    request.setAttribute("name", "jack");
    session.setAttribute("age", 20);
    session.setAttribute("name", "tom");
%>

<h2>empty运算符</h2>
<%
    String str = "hello";
    request.setAttribute("str",str);
%>
${not empty str}

${requestScope.name}
${sessionScope.age}
${sessionScope.name}






</body>
</html>
