package com.skilldistillery.books.data;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookDAOImpl implements BookDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Book findBookByISBN(String isbn) {
		Book book = null;
		String query = "select book from Book book where book.isbn = :isbn";
		List<Book> books = em.createQuery(query, Book.class)
				.setParameter("isbn", isbn)
				.getResultList();
		if (books.size() > 0) {
			book = books.get(0);
		}
		return book;
	}

	@Override
	public Book findBookByISBN13(int isbn) {
		Book book = null;
		String query = "select book from Book book where book.isbn13 = :isbn";
		List<Book> books = em.createQuery(query, Book.class)
				.setParameter("isbn", isbn)
				.getResultList();
		if (books.size() > 0) {
			book = books.get(0);
		}
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		String query = "select book from Book book";
		return em.createQuery(query, Book.class).getResultList();
	}

	@Override
	public void deleteBook(int id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}

	@Override
	public void updateBook(int id) {
		Book book = em.find(Book.class, id);
		em.refresh(book);
	}

	@Override
	public void createBook(Book book) {
		em.persist(book);
	}

}
