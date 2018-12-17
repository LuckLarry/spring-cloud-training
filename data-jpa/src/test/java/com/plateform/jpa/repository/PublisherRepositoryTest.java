package com.plateform.jpa.repository;

import com.plateform.jpa.entity.Book;
import com.plateform.jpa.entity.BookDetail;
import com.plateform.jpa.entity.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @Before
    public void before(){
        Book book1 = new Book("mybatis init 1",new BookDetail(20));
        Book book2 = new Book("中国进化史",new BookDetail(40));
        Book book3 = new Book("代言人的自我修养",new BookDetail(60));
        Book book4 = new Book("按摩技法",new BookDetail(80));
        Publisher publisher1 = new Publisher();
        publisher1.setName("中国人民出版社");
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        publisher1.setBooks(books);
        publisherRepository.save(publisher1);
    }

    @Test
    public void findByName() {
    }
}