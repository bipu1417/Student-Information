<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="student" action="" method="post">
		<table align="center">
			<tr>
				<td><form:label path="rollno">Roll No:</form:label></td>
				<td><form:input path="rollno" name="rollno" id="rollno" />
				</td>
			</tr>
			<tr>
				<td><form:label path="name">Name: </form:label></td>
				<td><form:password path="name" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><form:label path="age">Age: </form:label></td>
				<td><form:input path="age" name="age"	id="age" /></td>
			</tr>
			<tr>
                        <td></td>
                        <td>
                            <form:button id="add" name="add">ADD</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </body>
        </html>