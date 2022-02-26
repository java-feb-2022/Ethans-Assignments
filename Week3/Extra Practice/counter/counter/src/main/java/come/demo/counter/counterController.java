package come.demo.counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
@Controller
public class counterController {
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			session.setAttribute("count", (Integer)session.getAttribute("count")+1);
		}
		Integer count = (Integer)session.getAttribute("count");
		model.addAttribute("count", count);
		return "index.jsp";
	}
}
