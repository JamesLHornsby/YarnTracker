<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!-- for navigation -->
<%@ taglib tagdir="/WEB-INF/tags" prefix="ypm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script src="resources/static/js/yarns.module.js"></script>
<script src="resources/static/js/service/yarns.service.js"></script>
<script src="resources/static/js/controller/yarns.controller.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- My own css -->
<link rel="stylesheet" href="resources/style.css">

<meta charset="ISO-8859-1">
<title>The Yarn Matcher</title>
</head>


<body ng-app="YarnPatternMatcherApp" class="ng-cloak">

	<ypm:myNav />

	<div class="generic-container"
		ng-controller="YarnPatternMatcherController as ctrl">

		<div id="yarnlist" class="panel panel-default">

			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="lead">List of Patterns</span>
				</div>
				<div class="tablecontainer">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>ID.</th>
								<th>Name</th>
								<th>Size</th>
								<th>Colors</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="currentPattern in ctrl.patterns">
								<td><span ng-bind="currentPattern.id"></span></td>
								<td><span ng-bind="currentPattern.name"></span></td>
								<td><span ng-bind="currentPattern.size"></span></td>
								<td><span ng-bind="currentPattern.colors"></span></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<div id="patternlist">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="lead">List of Yarn</span>
				</div>
				<div class="tablecontainer">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>ID.</th>
								<th>Color</th>
								<th>Location</th>
								<th>Size</th>
								<th>Skeins</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="currentYarn in ctrl.yarns">
								<td><span ng-bind="currentYarn.id"></span></td>
								<td><span ng-bind="currentYarn.color"></span></td>
								<td><span ng-bind="currentYarn.location"></span></td>
								<td><span ng-bind="currentYarn.size"></span></td>
								<td><span ng-bind="currentYarn.length"></span></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
<%-- 	<!-- Notes of Yarn to buy -->
<div id="noteArea">
	<form method="POST" action="addNote" modelAttribute="note">
		<table>
			<tr>
				<td><label>Note<label></td>
				<td><input type="text" path="note" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td>Note:</td>
			<td>${note}</td>
	</table>
	<br/>
	<div id="noteArea">
		<p>Here are your notes:</p>
		<p>Not using JSTL: ${note}</p>
		<c:forEach items="${notes}" var="note">
			<tr>
				<td>Here's JSTL: ${note.contents}</td>
			</tr>
		</c:forEach>
	</div> --%>
</div>
</body>
</html>