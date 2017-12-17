package pl.coderslab.service;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Book;

@Component
public interface BookService {
	Book add(Book book);

	Book update(Book book);

	Book remove(long id);

	Book getById(long id);

	List<Book> getBooks();

	void setBooks(List<Book> books);
}
