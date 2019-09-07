package com.skilldistillery.books.data;

import java.util.List;

import com.skilldistillery.books.entities.Book;

public interface BookDAO {
	Book findBookByISBN(String isbn);
	Book findBookByISBN13(int isbn);
	List<Book> getAllBooks();
	boolean deleteBook(int id);
	void updateBook(int id);
	void createBook(Book book);
}
