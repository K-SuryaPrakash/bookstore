package com.example.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.model.Book;

public interface BookRepo extends JpaRepository<Book,Long> {

}
