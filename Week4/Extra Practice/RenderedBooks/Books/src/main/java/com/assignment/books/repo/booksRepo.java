package com.assignment.books.repo;
import com.assignment.books.models.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
@Repository
public interface booksRepo extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
	Long deleteById(Integer id);
}
