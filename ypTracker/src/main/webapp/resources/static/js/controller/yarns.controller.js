'use strict';

angular.module('YarnPatternMatcherApp').controller('YarnPatternMatcherController',
		['YarnPatternMatcherService', function(YarnPatternMatcherService) {
			var self = this;
			self.yarn = {
				id : null,
				color: '',
				location: ''
			};
			self.yarns = [];
			
			self.fetchAllYarn = function() {
				YarnPatternMatcherService.fetchAllYarn().then(function(data) {
					self.yarns = data;
				},
				function(errResponse) {
					console.error('Error while fetching Yarn');
				});
			}
			//submit to create or update...
			self.submitYarn = function() {
				if(self.yarn.id==null) {
					self.createYarn();
				} else {
					self.updateYarn(self.yarn, self.yarn.id);
				}
			}
			
			//pick from list to update...
			self.edit = function(id) {
				for(var i = 0;i < self.yarns.length; i++) {
					if(self.yarns[i].id ===id) {
						self.yarn = angular.copy(self.yarns[i]);
						break;
					}
				}
			}
			//create...
			self.createYarn = function() {
				return YarnPatternMatcherService.createYarn(self.yarn).then(function() {
					self.fetchAllYarn();
				}).then(function() { self.resetYarn()});
			}
			//update...
			self.updateYarn = function(yarn, id) {
				YarnPatternMatcherService.updateYarn(yarn, id)
				.then(
					self.fetchAllYarn,
					function(errResponse) {
						console.error('Error while updating Yarn');
					}
				).then(function() { self.resetYarn()});
			}
			

			
			self.deleteYarn = function(yarn) {
				return YarnPatternMatcherService.deleteYarn(yarn.id).then( function() {
					self.fetchAllYarn();
				});
			}
			
			//clear button
			self.resetYarn = function() {
				self.yarn = {};
			}
			
			self.fetchAllYarn();
			
	/* Patterns below... */
			
			self.pattern = {
				id : null,
				name: '',
				size: '',
				colors: ''
			};
			self.patterns = [];
			
			self.fetchAllPatterns = function() {
				YarnPatternMatcherService.fetchAllPatterns().then(function(data) {
					self.patterns = data;
				},
				function(errResponse) {
					console.error('Error while fetching Patterns');
				});
			}
			//submit to create or update...
			self.submitPattern = function() {
				if(self.pattern.id==null) {
					self.createPattern();
				} else {
					self.updatePattern(self.pattern, self.pattern.id);
				}
			}
			
			//pick pattern from list to update...
			self.editPattern = function(id) {
				for(var i = 0;i < self.patterns.length; i++) {
					if(self.patterns[i].id ===id) {
						self.pattern = angular.copy(self.patterns[i]);
						break;
					}
				}
			}
			
			//create...
			self.createPattern = function() {
				return YarnPatternMatcherService.createPattern(self.pattern).then(function() {
					self.fetchAllPatterns();
				}).then(function() { self.resetPattern()});
			}
			//update...
			self.updatePattern = function(pattern, id) {
				YarnPatternMatcherService.updatePattern(pattern, id)
				.then(
					self.fetchAllPatterns,
					function(errResponse) {
						console.error('Error while updating Patterns');
					}
				).then(function() { self.resetPattern()});
			}
			
			self.deletePattern = function(pattern) {
				return YarnPatternMatcherService.deletePattern(pattern.id).then( function() {
					self.fetchAllPatterns();
				});
			}
			
			//clear button
			self.resetPattern = function() {
				self.pattern = {};
			}
			
			
			self.fetchAllPatterns();
			
			
		}]);