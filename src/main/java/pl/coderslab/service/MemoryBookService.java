package pl.coderslab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Book;

@Component
public class MemoryBookService implements BookService {
	private List<Book> books;

	public MemoryBookService() {
		books = new ArrayList<>();
	}

	@Override
	public Book add(Book book) {
		book.setId(nextId());
		books.add(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		Book b = getById(book.getId());
		b.setAuthor(book.getAuthor());
		b.setIsbn(book.getIsbn());
		b.setPublisher(book.getPublisher());
		b.setTitle(book.getTitle());
		b.setType(book.getType());
		return b;
	}

	@Override
	public Book remove(long id) {
		Book b = getById(id);
		books.remove(b);
		return b;
	}

	@Override
	public Book getById(long id) {
		for (Book b : books) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;
	}

	@Override
	public List<Book> getBooks() {
		return books;
	}

	@Override
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	private long nextId() {
		return books.size() + 1;
	}
}
