package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.repository.BookReposirory;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookReposirory bookReposirory;

	@Override
	public Boolean saveBook(Book book) {
		// TODO Auto-generated method stub
		bookReposirory.save(book);
		System.out.println("save success");
		return true;
	}

	@Override
	public List<Book> getAllBook() {
		return bookReposirory.findAll();
	}

	@Override
	public Book getByBookId(Integer bookId) {
		Optional<Book> b=bookReposirory.findById(bookId);
		if(b!=null)
		{
			return b.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Boolean updateBook(Integer bookId,Book book) {
		boolean b=bookReposirory.existsById(bookId);
		book.setBookId(bookId);
		if(b)
		{
			bookReposirory.save(book);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Boolean deleteByBookId(Integer bookId) {
		boolean b=bookReposirory.existsById(bookId);
		if(b)
		{
			bookReposirory.deleteById(bookId);
			return true;
		}
		else {
			return false;
		}
	}

}
