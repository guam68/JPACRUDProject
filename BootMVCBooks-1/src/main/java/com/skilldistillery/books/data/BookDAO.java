package com.skilldistillery.books.data;

import java.util.List;

import com.skilldistillery.books.entities.Book;

public interface BookDAO {
	List<Book> findBookByISBN(String isbn);
	List<Book> findBookByISBN13(long isbn13);
	List<Book> getAllBooks();
	boolean deleteBook(int id);
	void createBook(Book book);
	void updateBook(Book book);
	List<Book> findBookByKeyword(String keyword);
}
