package com.plateform.jpa.repository;

import com.plateform.jpa.entity.Book;
import com.plateform.jpa.entity.BookDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
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
//        bookRepository.deleteAll();
    }

    @Test
    public void findByName() {
        Book book = bookRepository.findByName("Spring init 1");
        System.err.println(book);
    }

    @Test
    public void findPage(){
        Integer page = 1;
        Integer pageSize = 1;
        PageRequest request = new PageRequest(page,pageSize);
        Page<Book> books = bookRepository.findAll(request);
        log.error("book {}",books);
    }
    @Test
    public void findPageAble(){
        Integer page = 1;
        Integer pageSize = 1;
        Integer id = 5;
        String name = "init 3";//模拟传入的查询条件
        Pageable pageable = new PageRequest(page-1,pageSize,
                new Sort(Sort.Direction.ASC,"name"));
        Page<Book> books = bookRepository.findAll(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> lstPredicates = new ArrayList<>();
                if(!StringUtils.isEmpty(name)){
                    lstPredicates.add(criteriaBuilder.like(root.get("name"),"%"+name+"%"));
                }
                if (null != id){
                    lstPredicates.add(criteriaBuilder.equal(root.get("id"),id));
                }

                Predicate[] arrayPredicates = new Predicate[lstPredicates.size()];
                return criteriaBuilder.and(lstPredicates.toArray(arrayPredicates));
            }
        },pageable);
        log.error("book {}",books);
    }

    @Test
    public void findPageAbleLambda(){
        Integer page = 1;
        Integer pageSize = 1;
        Integer id = 5;
        String name = "init 3";//模拟传入的查询条件
//        Pageable pageable = new PageRequest(page-1,pageSize,
//                new Sort(Sort.Direction.ASC,"name"));
        Pageable pageable = PageRequest.of(page-1,pageSize,
                new Sort(Sort.Direction.ASC,"name"));
        Page<Book> books = bookRepository.findAll((root,criteriaQuery,criteriaBuilder)->{
            List<Predicate> lstPredicates = new ArrayList<>();
            if(!StringUtils.isEmpty(name)){
                lstPredicates.add(criteriaBuilder.like(root.get("name"),"%"+name+"%"));
            }
            if (null != id){
                lstPredicates.add(criteriaBuilder.equal(root.get("id"),id));
            }
            Predicate[] arrayPredicates = new Predicate[lstPredicates.size()];
            return criteriaBuilder.and(lstPredicates.toArray(arrayPredicates));
        },pageable);
        log.error("book {}",books);
    }
}