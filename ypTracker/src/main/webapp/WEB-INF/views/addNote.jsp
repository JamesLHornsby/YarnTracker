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
<title>Add Notes Here!</title>
</head>
<body>

		<ypm:myNav />
		
	<div id="noteArea">
		<form:form method="POST" action="addNewNote" modelAttribute="note">
			<table>
				
				<tr>
					<td><label for="note1"> Note</label></td>
					<td><form:input id="note1" path="contents" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>