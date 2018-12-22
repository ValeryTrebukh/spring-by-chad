<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome to Hell</h2>

    <hr>

    <p>
        User: <security:authentication property="principal.username"/>
        <br>
        Role(s): <security:authentication property="principal.authorities"/>

    </p>

    <hr>

    <security:authorize access="hasRole('MODERATOR')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
            (Only for manager people)
        </p>
        <hr>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">Administration</a>
            (Only for admins)
        </p>
        <hr>
    </security:authorize>

    <form:form action="${pageContext.request.contextPath}/logout" method="post" >
        <input type="submit" value="Logout"/>
    </form:form>
</body>
</html>
