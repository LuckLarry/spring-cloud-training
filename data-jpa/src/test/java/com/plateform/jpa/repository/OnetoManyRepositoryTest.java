package com.plateform.jpa.repository;

import com.plateform.jpa.entity.Book;
import com.plateform.jpa.entity.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnetoManyRepositoryTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void init (){
        Book book1 = new Book("spring");
        Book book2 = new Book("mvc");
        Book book3 = new Book("mybatis");
        Publisher publisher = new Publisher("zhonghua");
        Set<Book> set = new HashSet<>();
        set.add(book1);
        set.add(book2);
        set.add(book3);
        publisher.setBooks(set);
        publisherRepository.save(publisher);
    }

    @Test
    public void findByName() {
        Publisher publisher = publisherRepository.findByName("zhonghua");
        System.err.println(publisher.getBooks());
    }
}