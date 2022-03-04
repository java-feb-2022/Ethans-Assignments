package com.company.savetravels.Repos;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.company.savetravels.models.Expense;
@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
}
