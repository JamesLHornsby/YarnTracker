package com.megagiganto.ypTracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.megagiganto.ypTracker.api.model.Note;
import com.megagiganto.ypTracker.api.service.NoteService;
import com.megagiganto.ypTracker.app.model.NoteImpl;

@Controller
public class YarnPageController {

	@Autowired
	NoteService noteService;
	
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
	
	//synchronous calls below...
	//calls viewNote and adds notes
	@GetMapping(value = "/notePage")
	public String getNotePage(Model model) {
		model.addAttribute("note",new NoteImpl());
		model.addAttribute("notes", noteService.getAllNotes());
		model.addAttribute("displayheader",true);
		return "viewNote";
	}
	
	
	//calls addNotes
	@GetMapping(value = "/addNotes")
	public String addNotesPage(Model model) {
		model.addAttribute("note", new NoteImpl());
		model.addAttribute("displayheader",true);
		return "addNote";
	}
	//and gets form ready
	@PostMapping("/addNewNote")
	public ModelAndView addNote(@Valid @ModelAttribute("note") NoteImpl note, Errors errors, ModelAndView mv,
				RedirectAttributes redirectAttributes){
					noteService.addNote(note);
					mv.addObject("note", note);
					mv.setViewName("result-page");
					return mv;
				}
	
}
