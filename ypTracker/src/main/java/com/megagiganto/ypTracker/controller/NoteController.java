package com.megagiganto.ypTracker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.megagiganto.ypTracker.api.model.Note;
import com.megagiganto.ypTracker.api.service.NoteService;

@Controller
@ControllerAdvice
public class NoteController {
	// SYNCHRONOUS!!!

	@Autowired
	NoteService noteService;

	/*
	 * @PostMapping(value = "/addNote") public RedirectView
	 * addNote(@ModelAttribute("note") NoteImpl note, RedirectAttributes
	 * redirectAttributes) { final RedirectView redirectView = new
	 * RedirectView("/addNote", true);
	 * redirectAttributes.addFlashAttribute("savedNote",note);
	 * redirectAttributes.addFlashAttribute("addNoteSuccess", true);
	 * redirectAttributes.addFlashAttribute("displayheader", true); return
	 * redirectView; }
	 * 
	 * @GetMapping(value="/addNoteNew") public String addNoteView(Model model) {
	 * model.addAttribute("note", new NoteImpl());
	 * model.addAttribute("displayheader", true); return "addNote"; }
	 */
	
	private Map<Long, Note> noteMap = new HashMap<>();
	
	@PostMapping(value= "/addNewNote")
	public String submit(@ModelAttribute("note") Note note,
	BindingResult result, ModelMap model){
		if(result.hasErrors()) {
			return "error";
		}
		model.addAttribute("contents", note.getContents());
		return "addNote";
		
	}
	
	/*
	 * @PostMapping(value = "/addNote") public String submit(@ModelAttribute("note")
	 * NoteImpl note, BindingResult result, ModelMap model) { if
	 * (result.hasErrors()) { return "error"; } model.addAttribute("note",
	 * noteDAO.getAllNotes()); return "matcher"; }
	 */
	@GetMapping("/addNewNote")
	public String readNotes(Model model) {
		model.addAttribute("notes", noteService.getAllNotes());
		model.addAttribute("displayheader", true);
		return "addNote";
	}

}
