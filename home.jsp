<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    	 <%@ page isELIgnored="false" %> 
        <div align="center">
            <h1>Student List</h1>
            <table border="1">
            	<th>No</th>
                <th>Roll No</th>
                <th>Name</th>
                <th>Degree</th>
                <th>Department</th>
                <th>Address</th>
                <th>CGPA</th>
                 
                <c:forEach var="student" items="${applicationScope['studentList'] }" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${student.rollno }</td>
                    <td>${student.name}</td> 
                    <td>${student.degree}</td>
                    <td>${student.department}</td>
                    <td>${student.address }</td>
                    <td>${student.cgpa }</td>
                    <td><c:out value="${student.name}"/></td>
                
                    
                </tr>
                </c:forEach>             
            </table>
        </div>
        <div>
        <c:forEach items="${applicationScope['studentList'] }"  var="student">
    <tr>
        <td>Roll No: <c:out value="${student.rollno}"/></td>
        <td>Name: <c:out value="${student.name}"/></td>  
    </tr>
</c:forEach>
        </div>
        
         
         <!--provide an html table start tag -->
   <table style="border: 1px solid;">
   <!-- iterate over the collection using forEach loop -->
   <c:forEach var="stud" items="${studentList}">
       <!-- create an html table row -->
       <tr>
       <!-- create cells of row -->
       <td>${stud.name}</td>
       <td>${stud.degree}</td>
       <!-- close row -->
       </tr>
       <!-- close the loop -->
   </c:forEach>
   <!-- close table -->
   </table>
         
    </body>
</html>