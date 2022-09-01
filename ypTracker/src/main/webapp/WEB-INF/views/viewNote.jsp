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
<title>View Notes Here!</title>
</head>
<body>

		<ypm:myNav />
		
	<!-- Notes of Yarn to buy -->
<div id="noteArea">
	<div >
		<p>Here are your notes:</p>
		<c:forEach items="${notes}" var="note">
			<tr>
				<td>${note.contents}</td>
			</tr>
		</c:forEach>
	</div>
	</div>
</body>
</html>