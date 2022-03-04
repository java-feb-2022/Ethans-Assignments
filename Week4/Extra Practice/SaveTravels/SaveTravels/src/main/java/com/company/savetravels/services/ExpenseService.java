package com.company.savetravels.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.company.savetravels.Repos.ExpenseRepo;
import com.company.savetravels.models.Expense;

@Service
public class ExpenseService {
	private final ExpenseRepo expenseRepo;
	public ExpenseService(ExpenseRepo repo) {
		this.expenseRepo = repo;
	}
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	public Expense createExpense(Expense E) {
		return expenseRepo.save(E);
	}
	public Expense findExpense(Long id) {
		Optional<Expense> OptE = expenseRepo.findById(id);
		if (OptE.isPresent()) {
			return OptE.get();
		}
		else {
			return null;
		}
	}
	public Expense update(Expense E) {
		E.update(E);
		return expenseRepo.save(E);
	}
}
