package com.assignment.books.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.assignment.books.models.Book;
import com.assignment.books.repo.booksRepo;

@Service
public class BookService {
	private final booksRepo bookRepo;
    
    public BookService(booksRepo bookRepository) {
        this.bookRepo = bookRepository;
    }
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
    	Book book = findBook(id);
    	book.update(title, desc, lang, pages);
    	return bookRepo.save(book);
    }
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }
}
