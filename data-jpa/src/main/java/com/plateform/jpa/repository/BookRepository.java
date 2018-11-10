package com.plateform.jpa.repository;

import com.plateform.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends
        JpaRepository<Book,Integer>,PagingAndSortingRepository<Book,Integer>,JpaSpecificationExecutor<Book> {
    Book findByName(String name);
}
