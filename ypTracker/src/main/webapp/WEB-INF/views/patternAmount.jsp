<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib tagdir="/WEB-INF/tags" prefix="ypm" %>

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

 	<ypm:myNav/>

	<div class="generic-container"
		ng-controller="YarnPatternMatcherController as ctrl">
		<!-- Yarn adding form -->
		<div class="panel panel-default">


			<!-- Pattern adding form -->

			<div id="addPatternSection" class="formcontainer">
				<form ng-submit="ctrl.submitPattern()" id="addPatternForm"
					name="addPatternForm" class="form-horizontal">
					<div class="panel-heading">
						<span class="lead">Add Your Patterns!</span>
					</div>
					<input type="hidden" ng-model="ctrl.pattern.id" />
					<!-- name -->
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="ycolor">Name
								of Pattern</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.pattern.name" id="pname"
									class="form-control input-sm" placeholder="Enter pattern name"
									ng-required="true" ng-minlength="3" />

							</div>
						</div>
					</div>
					<!-- size -->
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="psize">Pattern
								Size</label>
							<div class="col-md-7">
								<input type="number" min="0" ng-model="ctrl.pattern.size"
									id="psize" class="form-control input-sm"
									placeholder="Enter pattern size" required ng-minlength="1" />

							</div>
						</div>
					</div>
					<!-- Yarn Color -->
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="y1">Yarn
								Colors</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.pattern.colors" id="colors"
									class="form-control input-sm"
									placeholder="Enter your yarn colors" ng-required
									ng-minlength="1" />

							</div>
						</div>
					</div>


					<!-- submission -->
					<div class="row">
						<div class="form-group col-md-12">
							<div class="form-actions floatRight">
								<input type="submit"
									value="{{!ctrl.pattern.id ? 'Add' : 'Update'}}"
									class="btn btn-primary btn-sm">
								<button type="reset" id="clear"
									ng-click="
									ctrl.resetPattern()"
									class="btn btn-warning btn-sm"
									ng-disabled="addPatternForm$pristine">Reset Form</button>

							</div>
						</div>
					</div>
				</form>


			</div>
			<div id="patternlist" class="panel panel-default">
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
								<td>
									<button type="button"
										data-ng-click="ctrl.editPattern(currentPattern.id)"
										class="btn btn-success custom-width">Edit</button>
									<button type="button"
										data-ng-click="ctrl.deletePattern(currentPattern)"
										class="btn btn-danger custom-width">Remove</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>