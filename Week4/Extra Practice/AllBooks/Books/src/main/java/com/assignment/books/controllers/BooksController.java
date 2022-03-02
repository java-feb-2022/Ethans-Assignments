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
	@RequestMapping("/home")
	public String home(Model model) {
		List<Book> allbooks = bookService.allBooks();
		model.addAttribute("allbooks",allbooks);
		return "home.jsp";
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
	public String create() {
		return "create.jsp";
	}
	@PostMapping("/process")
	public String newBook(
			@RequestParam(value="title")String title,
			@RequestParam(value="desc")String desc,
			@RequestParam(value="lang")String lang,
			@RequestParam(value="pages")int pages
			) {
		Book newbook = new Book(title, desc, lang, pages);
		bookService.createBook(newbook);
		return "redirect:/home";
	}
}
