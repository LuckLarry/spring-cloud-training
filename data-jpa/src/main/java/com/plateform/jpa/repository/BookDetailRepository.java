package com.plateform.jpa.repository;

import com.plateform.jpa.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail,Integer> {
    BookDetail findByNumberOfPages(Integer numberOfPages);
}
