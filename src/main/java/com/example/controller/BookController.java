package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllData()
	{
		List<Book> lb=bookService.getAllBook();
		return new ResponseEntity<>(lb,HttpStatus.OK);
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getOneRecord(@PathVariable("id") Integer id)
	{
		Book b=bookService.getByBookId(id);
		if(b!=null)
		{
			return new ResponseEntity<Book>(b,HttpStatus.OK);
		}else {
			return new ResponseEntity<Book>(b,HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/book")
	public ResponseEntity<Boolean> saveBook(@RequestBody Book book)
	{
		Boolean b=bookService.saveBook(book);
		return new ResponseEntity<>(b,HttpStatus.CREATED);
	}
	@PutMapping("/book/{id}")
	public ResponseEntity<Boolean> updateBook(@PathVariable("id")Integer id,@RequestBody Book book)
	{
		boolean b=bookService.updateBook(id, book);
		if(b)
		{
			return new ResponseEntity<Boolean>(b,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(b,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable("id") Integer id)
	{
		boolean b=bookService.deleteByBookId(id);
		if(b)
		{
			return new ResponseEntity<String>("Record is deleted ",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(id+"is not exit in table.",HttpStatus.BAD_REQUEST);
		}
	}

}
