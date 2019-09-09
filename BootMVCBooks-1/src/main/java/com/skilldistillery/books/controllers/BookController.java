package com.skilldistillery.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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

	@RequestMapping(path = "getBookByIsbn.do", method = RequestMethod.GET, params = "search")
	public ModelAndView getBookByISBN(String search) {
		ModelAndView mv = new ModelAndView("bookDetail");
		List<Book> book = null;
		if (search.length() == 13) {
			try {
				System.out.println("in13");
				long isbn13 = Long.valueOf(search);
				System.out.println(isbn13);
				book = dao.findBookByISBN13(isbn13);
				System.out.println(book);
			} catch (NumberFormatException e) {
				System.out.println(e);
				book = dao.findBookByISBN(search);
			}
		} else {
				System.out.println("fallback");
			book = dao.findBookByISBN(search);
		}
		mv.addObject("book", book);
		System.out.println("finish get book mapping");
		return mv;
	}

	@RequestMapping(path = "getBookByKeyword.do", method = RequestMethod.GET, params = "search")
	public ModelAndView getBookByKeyword(String search) {
		ModelAndView mv = new ModelAndView("bookDetail");
		List<Book> books = null;
		books = dao.findBookByKeyword(search);
		mv.addObject("book", books);
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

	@RequestMapping(path = "showUpdateForm.do", method = RequestMethod.GET, params = "id")
	public ModelAndView updateBook(Integer id) {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("book", new Book());
		mv.addObject("id", id);
		return mv;
	}

	@RequestMapping(path = "updateBook.do", method = RequestMethod.POST)
	public ModelAndView updateBook(Book book, Errors errors, RedirectAttributes redAttrs) {
		ModelAndView mv = new ModelAndView();
		if (errors.hasErrors()) {
			mv.setViewName("redirect:/");
			redAttrs.addFlashAttribute("message", "Could not update book");
		} else {
			dao.updateBook(book);
			redAttrs.addFlashAttribute("message", "Book has been updated");
			mv.setViewName("redirect:/");
//			mv.addObject("book", book);
		}

		return mv;
	}

	@RequestMapping(path = "createBook.do", method = RequestMethod.POST)
	public ModelAndView createBook(Book book, Errors errors, RedirectAttributes redAttrs) {
		ModelAndView mv = new ModelAndView();
		if (errors.hasErrors()) {
			mv.setViewName("redirect:/");
			redAttrs.addFlashAttribute("message", "Could not create book");
		} else {
			dao.updateBook(book);
			redAttrs.addFlashAttribute("message", "Book Added");
			mv.setViewName("redirect:/");
//			mv.addObject("book", book);
		}

		return mv;
	}

}
