package com.platform.product.service;

import com.platform.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findByCAndCategoryTypeIn(List<Integer> categoryTypeList);
}
