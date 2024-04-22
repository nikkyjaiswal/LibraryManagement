package com.frankmoley.school.school.Data.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "author")
    private String author;
    @Column(name = "borrowed")
    private boolean borrowed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "borrowed_by")
    private User borrowedBy;

}


//Books-> The book’s table consists of the columns {BID, Book name, Price, Genre}
//Issue -> This table consists of the columns {IID, UID, BID, IssueDate, Period, ReturnDate, Fine}