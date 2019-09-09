package com.skilldistillery.books.data;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.books.entities.Book;

class BookDAOImplTests {
	private BookDAO dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		dao = new BookDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		dao = null;
	}

	@Test
	void test_find_book_by_isbn() {
		dao.deleteBook(777);
		List<Book> book = dao.findBookByISBN("439358078");
		System.out.println(book);
//		assertEquals(2, book.getId());
	}

}
