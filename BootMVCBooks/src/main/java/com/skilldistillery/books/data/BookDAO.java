package com.skilldistillery.books.data;

import java.awt.print.Book;
import java.util.List;

public interface BookDAO {
	Book findBookByISBN(String isbn);
	Book findBookByISBN13(int isbn);
	List<Book> getAllBooks();
	void deleteBook(int id);
	void updateBook(int id);
	void createBook(Book book);
}
