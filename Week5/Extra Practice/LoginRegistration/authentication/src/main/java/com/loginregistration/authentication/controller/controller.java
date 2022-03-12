package com.loginregistration.authentication.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.loginregistration.authentication.models.LoginUser;
import com.loginregistration.authentication.models.User;
import com.loginregistration.authentication.service.userService;

@Controller
public class controller {
    @Autowired
    private userService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        

    	userServ.validate(newUser, result);
        if(result.hasErrors()) {

            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }

        userServ.registerUser(newUser);
		session.setAttribute("loggedInUser", newUser);
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute("newUser") User user,@Valid @ModelAttribute("newLogin") LoginUser loginUser, 
			BindingResult result,HttpSession session) {
		userServ.authenticateUser(loginUser, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		User loggedInUser = userServ.findByEmail(loginUser.getEmail());
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/home";
	}
    @GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/home")
		public String dashboard(HttpSession session) {
			
		if(session.getAttribute("loggedInUser") != null) {
			return "home.jsp";
		} else {
			return "redirect:/";
		}
		
	}
    
}