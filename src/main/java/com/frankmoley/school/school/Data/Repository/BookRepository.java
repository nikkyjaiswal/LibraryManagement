package com.frankmoley.school.school.Data.Repository;

import com.frankmoley.school.school.Data.Entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



@Component
public interface BookRepository extends JpaRepository<Book, Integer> {

}
