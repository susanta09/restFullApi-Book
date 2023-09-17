package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Book;
@Service
public interface BookService {
	public Boolean saveBook(Book book);
	public List<Book> getAllBook();
	public Book getByBookId(Integer bookId);
	public Boolean updateBook(Integer bookId,Book book);
	public Boolean deleteByBookId(Integer bookId);
	

}
