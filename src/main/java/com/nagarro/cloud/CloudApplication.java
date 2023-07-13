package com.nagarro.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
@SpringBootApplication
@RestController
@RequestMapping("/book")
public class CloudApplication {
	
	 @Autowired
	    private BookRepository bookRepository;

	    @PostMapping
	    public Book saveBook(@RequestBody Book book) {
	        return bookRepository.save(book);
	    }

	    @GetMapping
	    public List<Book> findBooks() {
	        return bookRepository.findAll();
	    }

	    @GetMapping("/message")
	    public String message() {
	        return "Welcome to First Azure Deployment";
	    }
	   
	    @GetMapping("/{id}")
	    public Book findBook(@PathVariable int id) throws Exception {
	        Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not available"));
	        return book;
	    }

	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);
	}

}
