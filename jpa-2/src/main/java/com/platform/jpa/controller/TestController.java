package com.platform.jpa.controller;

import com.platform.jpa.data.Category;
import com.platform.jpa.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public Category index() {
        Category category = categoryRepository.findByCategoryName("C-1");
        return category;
    }
}
