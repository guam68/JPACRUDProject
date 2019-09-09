package com.skilldistillery.books.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.books.entities.Book;

@Service
@Transactional
public class BookDAOImpl implements BookDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Book> findBookByISBN(String isbn) {
		String query = "select book from Book book where book.isbn = :isbn";
		List<Book> books = em.createQuery(query, Book.class)
				.setParameter("isbn", isbn)
				.getResultList();
		return books;
	}

	@Override
	public List<Book> findBookByISBN13(long isbn) {
		String query = "select book from Book book where book.isbn13 = :isbn";
		List<Book> books = em.createQuery(query, Book.class)
				.setParameter("isbn", isbn)
				.getResultList();
		return books;
	}

	@Override
	public List<Book> findBookByKeyword(String keyword) {
		String query = "select book from Book book where book.title like :keyword";
		List<Book> books = em.createQuery(query, Book.class)
				.setParameter("keyword", "%" + keyword + "%")
				.getResultList();
		System.out.println(books);
		return books;
	}

	@Override
	public List<Book> getAllBooks() {
		String query = "select book from Book book where book.id < 15";
		return em.createQuery(query, Book.class).getResultList();
	}

	@Override
	public boolean deleteBook(int id) {
		Book book = em.find(Book.class, id);
		boolean isDeleted = false;
		try {
			em.remove(book);
			isDeleted = true;
		} catch(IllegalArgumentException e ) {
			System.err.println("Failed to delete book" + e);
		}
		
		return isDeleted;
	}

	@Override
	public void updateBook(Book book) {
		em.merge(book);
	}

	@Override
	public void createBook(Book book) {
		em.persist(book);
	}

}
