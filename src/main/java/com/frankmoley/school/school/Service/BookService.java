package com.frankmoley.school.school.Service;

import com.frankmoley.school.school.Data.Entity.Book;

import com.frankmoley.school.school.Data.Entity.User;
import com.frankmoley.school.school.Data.Repository.BookRepository;
import com.frankmoley.school.school.Data.Repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;


@Configuration
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> bookList() {
        return bookRepository.findAll();
    }

    public Book findBookById(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book borrowBookById(int bookId ,int userId) {
        Book book = findBookById(bookId);
        User user = userRepository.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return bookRepository.save(book);
        }
        return null;

    }

    public Book returnBookById(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);

        return bookRepository.save(book);
        }
     return null;
    }
}
/*
Create a new user
fetch all user


Add new book
Fetch all the books
Fetch specific book
Delete a book
Borrow a book
Return a book  */