package com.company.savetravels.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import com.company.savetravels.models.Expense;
import com.company.savetravels.services.ExpenseService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class expensesController {
	private final ExpenseService expServ;
	public expensesController(ExpenseService E) {
		this.expServ = E;
	}
	@RequestMapping("/home")
	public String newExpense(@ModelAttribute("expenses")Expense exp,ModelMap model) {
		model.addAttribute("name",expServ.allExpenses());
		return "index.jsp";
	}
	@PostMapping("/new")
	public String createExpense(@Valid @ModelAttribute("expenses")Expense exp, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("name",expServ.allExpenses());
			return "index.jsp";
		}
		expServ.createExpense(exp);
		return "redirect:/home";
	}
}
