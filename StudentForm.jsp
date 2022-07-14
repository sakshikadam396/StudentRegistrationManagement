<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="save" method="post">
<table>
<tr>
<td>firstname</td><td><input type="text" value="${student.firstname}" name="firstname"/> </td></tr>
<tr>
<td>lastname</td><td><input type="text" value="${student.lastname}" name="lastname"/> </td></tr>
<tr>
<td>Course</td><td><input type="text" value="${student.course}" name="course"/> </td>
</tr>
<tr>
<td>Country</td><td><input type="text" value="${student.country}" name="country"/> </td>
</tr>
<tr>
<td colspan="2"><input type="hidden" value='${student.id}' name="id"/><input type="submit"/></td></tr>
</table>

</form>
</body>
</html>
