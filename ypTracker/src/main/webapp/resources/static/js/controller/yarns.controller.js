'use strict';

angular.module('YarnPatternMatcherApp').controller('YarnPatternMatcherController',
		['YarnPatternMatcherService', function(YarnPatternMatcherService) {
			var self = this;
			self.yarn = {
				id : '',
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
			self.submit = function() {
				if(self.yarn.id===null) {
					createYarn();
				} else {
					updateYarn(self.yarn, self.yarn.id);
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
					//self.reset();
				});
			}
			//update...
			self.updateYarn = function(yarn, id) {
				YarnPatternMatcherService.updateYarn(yarn, id)
				.then(
					fetchAllYarn,
					function(errResponse) {
						console.error('Error while updating Yarn');
					}
				);
			}
			

			
			self.deleteYarn = function(yarn) {
				return YarnPatternMatcherService.deleteYarn(yarn.id).then( function() {
					self.fetchAllYarn();
				});
			}
			
			//clear button
			self.reset = function() {
				self.yarn = {};
			}
			
			self.fetchAllYarn();
			
	/* Patterns below... */
			
			self.pattern = {
				id : '',
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
			self.submit = function() {
				if(self.pattern.id===null) {
					createPattern();
				} else {
					updatePattern(self.pattern, self.pattern.id);
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
				});
			}
			//update...
			self.updatePattern = function(yarn, id) {
				YarnPatternMatcherService.updatePattern(pattern, id)
				.then(
					fetchAllPatterns,
					function(errResponse) {
						console.error('Error while updating Patterns');
					}
				);
			}
			
			self.deletePattern = function(pattern) {
				return YarnPatternMatcherService.deletePattern(pattern.id).then( function() {
					self.fetchAllPatterns();
				});
			}
			
			//clear button
			self.reset = function() {
				self.pattern = {};
			}
			
			
			self.fetchAllPatterns();
			
			
		}]);