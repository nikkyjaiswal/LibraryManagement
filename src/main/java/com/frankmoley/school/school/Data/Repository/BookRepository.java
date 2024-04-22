package com.frankmoley.school.school.Data.Repository;

import com.frankmoley.school.school.Data.Entity.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface BookRepository extends JpaRepository<Book, Integer> {

}
