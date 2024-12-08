package com.example.bookstore.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.bookstore.model.*;
import com.example.bookstore.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService ob;
	
	@PostMapping("/abc")
    public ResponseEntity<Book> get(@RequestBody Book b) {
        Book b1 = ob.get(b);
        return ResponseEntity.status(HttpStatus.CREATED).body(b1);
    }
	@GetMapping("/books")
	public List<Book> get2() {
		return ob.get1();
	}

	@GetMapping("book/{id}")
	public ResponseEntity<Book> get3(@PathVariable Long id) {
		Optional<Book> b = ob.choose(id);
		return b.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("del/{id}")
	public ResponseEntity<Void> get4(@PathVariable Long id) {
		if (!ob.choose(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ob.del(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("up/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book b) {
		if (!ob.choose(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		b.setId(id);
		Book usi = ob.get(b);
		return ResponseEntity.ok(usi);
	}

}
