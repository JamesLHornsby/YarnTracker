package com.megagiganto.ypTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YarnPageController {
	
	@GetMapping(value = "/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping(value = "/yarn")
	public String getYarnPage() {
		return "yarnAmount";
	}
	
	@GetMapping(value = "/pattern")
	public String getPatternPage() {
		return "patternAmount";
	}
	
	@GetMapping(value = "/ypm")
	public String getMatcherPage() {
		return "matcher";
	}
	
	@GetMapping(value = "/notePage")
	public String getNotePage() {
		return "addNote";
	}
	

}
