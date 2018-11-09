package com.plateform.jpa.repository;

import com.plateform.jpa.entity.Book;
import com.plateform.jpa.entity.BookDetail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDetailRepository bookDetailRepository;

    @Before
    public void init(){
        Book book1 = new Book("Spring init 1",new BookDetail(20));
        Book book2 = new Book("Spring init 2",new BookDetail(40));
        Book book3 = new Book("Spring init 3",new BookDetail(60));
        Book book4 = new Book("Spring init 4",new BookDetail(80));
        bookRepository.saveAll(Arrays.asList(book1,book2,book3,book4));
    }

    @After
    public void clear(){
        bookRepository.deleteAll();
    }

    @Test
    public void findByName() {
        Book book = bookRepository.findByName("Spring init 1");
        System.err.println(book);
    }
}