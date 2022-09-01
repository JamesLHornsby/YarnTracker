<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ypm"%>
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
<title>Yarn Matcher Page</title>
</head>
<body>

	 <ypm:myNav/>
	 
	<div id="mainIndex">
		<!-- Not Navbar -->
		<h1>Keep track of your yarn! Keep track of your patterns! See how
			they match up!</h1>
		<a href="/yarn">Add Your Yarn!</a> <span> * </span> <a href="/pattern">Add
			Your Patterns!</a> <span> * </span> <a href="/ypm">See how they match
			up!</a>
	</div>
</body>
</html>