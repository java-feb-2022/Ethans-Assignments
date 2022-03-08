package com.core.dojos_and_ninjas.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.core.dojos_and_ninjas.models.Dojo;
import com.core.dojos_and_ninjas.models.Ninja;
import com.core.dojos_and_ninjas.services.DojoService;
import com.core.dojos_and_ninjas.services.NinjaService;

@Controller
public class mainController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/dojo/new")
	public String dojo(@ModelAttribute("dojo") Dojo dojo) {
		return "Dojo.jsp";
	}
	
	@GetMapping("/ninja/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos",allDojos);
		return "Ninja.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(dojo.getName());
			return "Dojo.jsp";
		} else {
			dojoService.create(dojo);
			return "redirect:/dojos/"+dojo.getId();
		}
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "Ninja.jsp";
		} else {
			ninjaService.save(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo",dojoService.findDojo(id));
		return "show.jsp";
	}
}
