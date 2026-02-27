package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.BookDao;
import com.test.entity.Book;
import com.test.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookdao;
	
	@Override
	public Book saveBook(Book book) {
		return bookdao.saveBook(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookdao.updateBook(book);
	}

	@Override
	public Optional<Book> getBookById(int id) {
		return bookdao.getBookById(id);
	}

	@Override
	public List<Book> deleteBookById(int id) {
		return bookdao.deleteBookById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookdao.getAllBooks();
	}
	
}
