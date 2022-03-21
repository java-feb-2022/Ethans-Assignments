package com.exam.practice.controllers;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.exam.practice.models.LoginUser;
import com.exam.practice.models.Project;
import com.exam.practice.models.User;
import com.exam.practice.services.ProjectService;
import com.exam.practice.services.UserService;

@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class Maincontroller {
	@Autowired
    private UserService userServ;
    @Autowired
    private ProjectService projServ;
    
    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("newUser", new User());
    	model.addAttribute("newLogin", new LoginUser());
    	return "index.jsp";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser")User newUser, BindingResult result, Model model, HttpSession session) {
    	User user = userServ.register(newUser, result);
    	if (result.hasErrors()) {
    		model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
    	}
    	session.setAttribute("id", user.getId());
    	return "redirect:/home";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("id", user.getId());
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
    	if(session.getAttribute("id") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("projects", projServ.all());
    	model.addAttribute("user", userServ.findById((Long)session.getAttribute("id")));
    	return "home.jsp";
    }
    @GetMapping("/newProject")
    public String newProject(@ModelAttribute("project")Project proj, Model model, HttpSession session) {
    	User user = userServ.findById((Long)session.getAttribute("id"));
    	model.addAttribute("user", user);
    	return "create.jsp";
    }
    @PostMapping("/Project")
    public String createProject(@Valid @ModelAttribute("project")Project proj, BindingResult result) {
    	if (result.hasErrors()) {
    		return "create.jsp";
    	}
    	projServ.create(proj);
    	return "redirect:/home";
    }
    @GetMapping("/Project/{id}")
    public String view(Model model, @PathVariable Long id, HttpSession session) {
    	if(session.getAttribute("id") == null) {
    		return "redirect:/";
    	}
    	Project proj = projServ.findById(id);
    	model.addAttribute("project", proj);
    	model.addAttribute("user", userServ.findById((Long)session.getAttribute("id")));
    	return "view.jsp";
    }
    @GetMapping("/Project/{id}/edit")
    public String editProject(Model model, @PathVariable Long id, HttpSession session) {
    	if(session.getAttribute("id") == null) {
    		return "redirect:/";
    	}
    	Project project = projServ.findById(id);
    	model.addAttribute("project", project);
    	return "edit.jsp";
    }
    @PutMapping("/Project/{id}/update")
    public String update(@Valid @ModelAttribute("project") Project proj, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "edit.jsp";
    	}
        projServ.update(proj);
    	return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}
