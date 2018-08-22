<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students List</title>
</head>
<body>
 <%@ page isELIgnored="false" %> 

<h1>List</h1>
<p>${obj}</p>
<p>${obj.name}</p>
<p>${obj.rollno}</p>



<table>
        <c:forEach items="${studentList}" var="user">
            <tr>
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>


<p>${applicationScope['listStudent'] }</p>
<c:out value="check"/>
<c:forEach var="student" items="${listStudent}">
	<c:out value="${student.name}"/>
	<c:out value="check"/>
	

</c:forEach>
</body>
</html>