package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Book;

public interface BookReposirory extends JpaRepository<Book, Integer>{

}
