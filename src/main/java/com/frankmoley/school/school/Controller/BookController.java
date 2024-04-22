package com.frankmoley.school.school.Controller;

import com.frankmoley.school.school.Data.Entity.Book;
import com.frankmoley.school.school.Data.Entity.User;
import com.frankmoley.school.school.Data.Repository.BookRepository;
import com.frankmoley.school.school.Data.Repository.UserRepository;
import com.frankmoley.school.school.Service.BookService;
import com.frankmoley.school.school.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Configuration
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> bookList() {
        return bookService.bookList();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable int bookId) {
        return bookService.findBookById(bookId);

    }

    @PutMapping("/id")
    public Book updateBook(@PathVariable int bookId, Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable int bookId) {
        bookService.deleteBookById(bookId);

    }


    @PostMapping("/{bookID}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable int bookId, @PathVariable  int userId) {
        Book borrowBook = bookService.borrowBookById(bookId ,userId);
        if(borrowBook!=null)
        {return ResponseEntity.ok(borrowBook);}
        else{return ResponseEntity.badRequest().build();}
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book>  returnBook(int bookId) {
        Book returnBook = bookService.returnBookById(bookId);
        if (returnBook != null ) {
            return ResponseEntity.ok(returnBook);
        }
        else{return ResponseEntity.badRequest().build();}
    }


}


