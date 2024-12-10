package com.booklendinglibrarysystem.book_lending_library_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklendinglibrarysystem.book_lending_library_system.Entity.Book;
import com.booklendinglibrarysystem.book_lending_library_system.service.BookService;

@RestController
@RequestMapping("/api/manageBooks")



public class BookController {
    private final BookService bookService;  // create an object of another class to use methods of that class

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET REQUEST      -> working
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    // GET REQUEST      -> working
    @GetMapping("/{id}")
    // @PathVariable -> it means we are giving ID in URL.
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // GET By Author
    
    // @PostMapping("/addBook")
    // public Book storeBook(@RequestBody Book book) {
        //     Book savedbook = bookService.saveBook(book);
        //     return savedbook;
    // }
        
    // POST REQUEST     -> 
    @PostMapping("/addBook")
    public Book addNewBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return savedBook;
    }

    // PUT request      -> working
    @PutMapping("updateBook/{id}")
    public Book updateBookById(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    // DELETE Request   -> working
    @DeleteMapping("/deleteBook/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
