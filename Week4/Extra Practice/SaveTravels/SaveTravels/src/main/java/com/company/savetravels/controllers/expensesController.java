package com.company.savetravels.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import com.company.savetravels.models.Expense;
import com.company.savetravels.services.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
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
	@GetMapping("/edit/{id}")
	public String Edit(@PathVariable("id")Long id, Model model) {
		Expense exp = expServ.findExpense(id);
		model.addAttribute("expenses", exp);
		return "edit.jsp";
	}
	@PutMapping("/edit/{id}/process")
	public String update(@Valid @ModelAttribute("expenses") Expense exp, BindingResult result, @PathVariable Long id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(exp);
			return "edit.jsp";
		}
		Expense oldexp = expServ.findExpense(id);
		oldexp.update(exp);
		expServ.update(oldexp);
		return "redirect:/home";
	}
}
