package com.frankmoley.school.school.Data.Repository;

import com.frankmoley.school.school.Data.Entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component

public interface UserRepository extends JpaRepository<User, Integer> {
}
