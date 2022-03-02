package com.assignment.books.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import com.assignment.books.models.Book;
import com.assignment.books.services.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class BooksController {
	private final BookService bookService;
	public BooksController(BookService b) {
		this.bookService = b;
	}
	@RequestMapping("/{id}")
	public String show(Model model,@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		if (book == null) {
			return "redirect:/";
		}
		model.addAttribute("title", book.getTitle());
		model.addAttribute("desc", book.getDesc());
		model.addAttribute("lang", book.getLang());
		model.addAttribute("pages", book.getPages());
		return "show.jsp";
	}
	@RequestMapping("/new")
	public String newBook() {
		Book newbook = new Book("Hungry Caterpillar", "A childrens book.", "English", 122);
		bookService.createBook(newbook);
		return "show.jsp";
	}
}
