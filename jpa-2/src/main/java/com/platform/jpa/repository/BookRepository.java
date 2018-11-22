package com.platform.jpa.repository;

import com.platform.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByName(String name);
}
