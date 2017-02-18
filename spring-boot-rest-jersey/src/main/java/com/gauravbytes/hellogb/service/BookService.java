package com.gauravbytes.hellogb.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.gauravbytes.hellogb.model.Book;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Service
public class BookService {
	private final ConcurrentMap<String, Book> books;

	public BookService() {
		this.books = new ConcurrentHashMap<>();
	}

	public Collection<Book> getAllBooks() {
		Collection<Book> allBooks = books.values();
		return allBooks.isEmpty() ? Collections.emptyList() : new ArrayList<>(allBooks);
	}
	
	public Book getBook(String oid) {
		return books.get(oid);
	}
	
	public void addBook(Book book) {
		if (Objects.isNull(book.getOid())) book.setOid(UUID.randomUUID().toString());
		
		this.books.put(book.getOid(), book);
	}
	
	public Book updateBook(String oid, Book book) {
		if (books.containsKey(oid)) {
			return books.put(oid, book);
		}
		throw new BookNotFoundException("Can't update book. Book for oid: " + oid + " not found");
	}
	
	public void deleteBook(String oid) {
		if (!books.containsKey(oid)) {
			throw new BookNotFoundException("Can't delete book. Book for oid: " + oid + " not found");
		}
		this.books.remove(oid);
	}
}
