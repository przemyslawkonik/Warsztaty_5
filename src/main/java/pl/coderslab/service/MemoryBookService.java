package pl.coderslab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Book;

@Component
public class MemoryBookService {
	private List<Book> list;

	public MemoryBookService() {
		list = new ArrayList<>();
	}

	public Book add(Book book) {
		book.setId(nextId());
		list.add(book);
		return book;
	}

	public Book update(Book book) {
		Book b = getById(book.getId());
		b.setAuthor(book.getAuthor());
		b.setIsbn(book.getIsbn());
		b.setPublisher(book.getPublisher());
		b.setTitle(book.getTitle());
		b.setType(book.getType());
		return b;
	}

	public Book remove(Book book) {
		list.remove(book);
		return book;
	}

	public Book remove(long id) {
		Book b = getById(id);
		list.remove(b);
		return b;
	}

	public Book getById(long id) {
		for (Book b : list) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	private long nextId() {
		return list.size() + 1;
	}
}
