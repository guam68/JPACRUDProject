package com.skilldistillery.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.books.data.BookDAO;
import com.skilldistillery.books.entities.Book;

@Controller
public class BookController {
	@Autowired
	private BookDAO dao;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		List<Book> books = dao.getAllBooks();
		mv.addObject("books", books);
		return mv;
	}

	@RequestMapping(path = "getBook.do", method = RequestMethod.GET, params = "isbn")
	public ModelAndView getBookByISBN(String isbn) {
		ModelAndView mv = new ModelAndView("bookDetail");
		Book book = null;
		if (isbn.length() == 13) {
			try {
				int isbn13 = Integer.valueOf(isbn);
				book = dao.findBookByISBN13(isbn13);
			} catch (NumberFormatException e) {
				book = dao.findBookByISBN(isbn);
			}
		} else {
			book = dao.findBookByISBN(isbn);
		}
		mv.addObject("book", book);
		return mv;
	}
	
	@RequestMapping(path = "deleteBook.do", method = RequestMethod.GET, params = "id")
	public ModelAndView deleteBook(int id, RedirectAttributes redAttrs) {
		ModelAndView mv = new ModelAndView("redirect:/");
		if (dao.deleteBook(id)) {
			redAttrs.addFlashAttribute("message", "Book has been deleted");
		} else {
			redAttrs.addFlashAttribute("message", "Failed to delete book");
		}
		return mv;
	}

}
