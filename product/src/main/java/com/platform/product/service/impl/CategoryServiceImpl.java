package com.platform.product.service.impl;

import com.platform.product.dataobject.ProductCategory;
import com.platform.product.repository.ProductCategoryRepository;
import com.platform.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCAndCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> list = productCategoryRepository.findByCAndCategoryTypeIn(categoryTypeList);
        return list;
    }
}
