package com.skilldistillery.books.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.books.data.BookDAO;

@Controller
public class BookController {
	@Autowired
	private BookDAO dao;

	@RequestMapping(path = "/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("WEB-INF/index.jsp");
		List<Book> books = dao.getAllBooks();
		mv.addObject("books", books);
		return mv;
	}

	@RequestMapping(path = "getBook.do", method = RequestMethod.GET, params = "isbn")
	public ModelAndView getBookByISBN(String isbn) {
		ModelAndView mv = new ModelAndView("WEB-INF/bookDetail.jsp");
		List<Book> books = dao.getAllBooks();
		mv.addObject("books", books);
		return mv;
	}

}
