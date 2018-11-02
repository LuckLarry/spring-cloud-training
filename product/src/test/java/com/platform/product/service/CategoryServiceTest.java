package com.platform.product.service;

import com.platform.product.ProductApplicationTests;
import com.platform.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class CategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;


    @Test
    public void findByCAndCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCAndCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}