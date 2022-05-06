<%@ page import="com.cx.web.cookie.CookieDemo01" %>
<%@ page import="com.cx.web.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="true">
    <h1 style="color: blue; font-size: 100px">
        true~~~
    </h1>
</c:if>
<%
    request.setAttribute("number",4);
%>

<%
    User user = new User();
    user.setName("tom");
    user.setAge(20);
    user.setAddress("su zhou");
    request.setAttribute("usr",user);
%>

${requestScope.usr}<br>
${requestScope.usr.name}<br>
${requestScope.usr.age}<br>
${requestScope.usr.address}


<c:choose>
    <c:when test="${number==1}">周一</c:when>
    <c:when test="${number==2}">周二</c:when>
    <c:when test="${number==3}">周三</c:when>
    <c:when test="${number==4}">周四</c:when>
    <c:when test="${number==5}">周五</c:when>
    <c:when test="${number==6}">周六</c:when>
    <c:when test="${number==7}">周日</c:when>
</c:choose>

<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
<%--    ${i}<br>--%>
    ${s.index}<br>
<%--    ${s.count}--%>
</c:forEach>

</body>
</html>
