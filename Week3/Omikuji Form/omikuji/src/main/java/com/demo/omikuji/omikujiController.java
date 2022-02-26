package com.demo.omikuji;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
@Controller
public class omikujiController {
	@RequestMapping("/")
	public String imLazy() {
		return "redirect:/Omikuji";
	}
	@RequestMapping("/Omikuji")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/process")
	public String process(
			HttpSession session,
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city")String city,
			@RequestParam(value="name")String name,
			@RequestParam(value="hobby")String hobby,
			@RequestParam(value="thing")String thing,
			@RequestParam(value="text")String text
			) {
		session.setAttribute("Omikuji", "In " + number + " years, you will live in " + city + " with " + name + " as your roommate, " + hobby + " for a living. The next time you see a " + thing + " you will have goodluck. Also " + text + ".");
		return "redirect:/show";
	}
	@RequestMapping("/show")
	public String show(Model model, HttpSession session) {
		String Omikuji = (String)session.getAttribute("Omikuji");
		model.addAttribute("Omikuji", Omikuji);
		return "show.jsp";
	}
}
