<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

    The student is confirmed: ${student.firstName} ${student.lastName}
    <br>
    The student is from ${student.country}

    <br>
    The student is writing on ${student.favLang}

</body>
</html>
