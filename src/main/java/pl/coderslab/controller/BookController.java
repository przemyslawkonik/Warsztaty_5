package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private MemoryBookService bookService;

	@Autowired
	public BookController(MemoryBookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("hello")
	public String hello() {
		return "{hello: World}";
	}

	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming");
	}

	@GetMapping("/")
	public List<Book> books() {
		return bookService.getList();
	}

	@GetMapping("/{id}")
	public Book book(@PathVariable long id) {
		return bookService.getList().get((int) (id - 1));
	}

}
