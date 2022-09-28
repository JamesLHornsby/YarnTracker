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

	<!-- Not Navbar -->

	<div class="generic-container"
		ng-controller="YarnPatternMatcherController as ctrl">
		<!-- Yarn adding form -->
		<div class="panel panel-default">

			<div id="addYarnSection" class="formcontainer">
				<form ng-submit="ctrl.submitYarn()" id="addYarnForm"
					name="addYarnForm" class="form-horizontal">
					<div class="panel-heading">
						<span class="lead">Add Your Yarn!</span>
					</div>
					<input type="hidden" ng-model="ctrl.yarn.id" />
					<!-- color -->
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="ycolor">Color</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.yarn.color" id="ycolor"
									class="form-control input-sm" placeholder="Enter yarn color"
									ng-required="true" ng-minlength="3" />
							</div>
						</div>
					</div>
					<!-- size -->
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="ysize">Size</label>
							<div class="col-md-7">
								<input type="number" min="0" ng-model="ctrl.yarn.size"
									id="ysize" class="form-control input-sm"
									placeholder="Enter yarn size" required ng-minlength="1" />

							</div>
						</div>
					</div>
					<!-- length -->
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="ylength">How
								many Skeins</label>
							<div class="col-md-7">
								<input type="number" step=".1" min="0"
									ng-model="ctrl.yarn.length" id="ylength"
									class="form-control input-sm"
									placeholder="Enter how amount in skeins" required
									ng-minlength="1" />

							</div>
						</div>
					</div>
					<!-- location -->
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="location">Location</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.yarn.location" id="location"
									class="form-control input-sm"
									placeholder="Enter yarn location (not required)" />
							</div>
						</div>
					</div>
					<!-- submission -->
					<div class="row">
						<div class="form-group col-md-12">
							<div class="form-actions floatRight">
								<input type="submit" id="submit"
									value="{{!ctrl.yarn.id ? 'Add' : 'Update'}}"
									class="btn btn-primary btn-sm">
								<button ng-click="ctrl.resetYarn()" id="clear" type="reset" class="btn btn-warning btn-sm">Reset Form</button>
							</div>
						</div>
					</div>
				</form>
			</div>

		</div>
		<div id="yarnlist" class="panel panel-default">
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
							<td><span id="addedYarnColor" ng-bind="currentYarn.color"></span></td>
							<td><span ng-bind="currentYarn.location"></span></td>
							<td><span ng-bind="currentYarn.size"></span></td>
							<td><span ng-bind="currentYarn.length"></span></td>
							<td>
								<button type="button" id="editButton" data-ng-click="ctrl.edit(currentYarn.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" id="deleteButton"
									data-ng-click="ctrl.deleteYarn(currentYarn)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>



		</div>
	</div>
</body>
</html>