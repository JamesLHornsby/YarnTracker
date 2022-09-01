<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ypm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- My own css -->
<link rel="stylesheet" href="resources/style.css">

<meta charset="ISO-8859-1">
<title>Keep Notes Here!</title>
</head>
<body>

		<ypm:myNav />
		
	<!-- Notes of Yarn to buy -->
<div id="noteArea">
	<form:form method="POST" action="/addNewNote" modelAttribute="note">
		<table>
			<tr>
				<td><form:label path="contents"> Note</form:label></td>
				<td><form:input path="contents" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form:form>

	<br/>
	<div id="noteArea">
		<p>Here are your notes:</p>
		<c:forEach items="${notes}" var="note">
			<tr>
				<td>Here's JSTL: ${note.contents}</td>
			</tr>
		</c:forEach>
	</div>
	</div>
</body>
</html>