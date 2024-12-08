package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.model.*;
import com.example.bookstore.dao.*;
@Service
public class BookService {
	@Autowired
	BookRepo ob;
	
	public Book get(Book b) {
		return ob.save(b);
	}
	public List<Book> get1() {
		return ob.findAll();
	}

	public Optional<Book> choose(Long id) {
		return ob.findById(id);
	}

	public void del(Long id) {
		ob.deleteById(id);
	}

}
