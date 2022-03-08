package com.school.languages.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import com.school.languages.models.Language;
import com.school.languages.services.LangService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class LangController {
	private final LangService langServ;
	public LangController(LangService E) {
		this.langServ = E;
	}
	@RequestMapping("/home")
	public String newLanguage(@ModelAttribute("languages")Language lang,ModelMap model) {
		model.addAttribute("name",langServ.allLangs());
		return "index.jsp";
	}
	@PostMapping("/new")
	public String createLanguage(@Valid @ModelAttribute("languages")Language lang, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("name",langServ.allLangs());
			return "index.jsp";
		}
		langServ.save(lang);
		return "redirect:/home";
	}
	@GetMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		Language lang = langServ.findLanguage(id);
		model.addAttribute("language", lang);
		return "view.jsp";
	}
	@GetMapping("/edit/{id}")
	public String Edit(@PathVariable("id")Long id, Model model, HttpSession Session) {
		Language lang = langServ.findLanguage(id);
		model.addAttribute("languages", lang);
		Session.setAttribute("id", id);
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}/process")
	public String update(@Valid @ModelAttribute("languages") Language lang, BindingResult result, @PathVariable Long id,HttpSession Session) {
		if(result.hasErrors()) {
			return "redirect:/edit/"+id;
		}
		Language oldLang = langServ.findLanguage(id);
		oldLang.update(lang);
		langServ.save(oldLang);
		return "redirect:/home";
	}
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		langServ.delete(id);
		return "redirect:/home";
	}
}
