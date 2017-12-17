package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private MemoryBookService mbs;

	@Autowired
	public BookController(MemoryBookService mbs) {
		this.mbs = mbs;
	}

	@GetMapping("")
	public List<Book> getBooks() {
		return mbs.getList();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable long id) {
		return mbs.getById(id);
	}

	@PostMapping("")
	public Book addBook(@RequestBody Book book) {
		return mbs.add(book);
	}

	@DeleteMapping("/{id}")
	public Book removeBook(@PathVariable long id) {
		return mbs.remove(id);
	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable long id) {
		book.setId(id);
		return mbs.update(book);
	}

}
