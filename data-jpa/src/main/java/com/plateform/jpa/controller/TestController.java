package com.plateform.jpa.controller;

import com.plateform.jpa.entity.Book;
import com.plateform.jpa.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private BookRepository bookRepository;


    @RequestMapping("/index")
    public Page<Book> index(@PageableDefault Pageable pageable,String name){
        Page<Book> books = bookRepository.findAll((root, query, criteriaBuilder)->{
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(name)){
                predicates.add(criteriaBuilder.like(root.get("name"),"%"+name+"%"));
            }
            Predicate[] arrayPredicate = new Predicate[predicates.size()];
            return criteriaBuilder.and(predicates.toArray(arrayPredicate));
        },pageable);
        return books;
    }

}
