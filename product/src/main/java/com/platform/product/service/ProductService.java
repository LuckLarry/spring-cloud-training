package com.platform.product.service;

import com.platform.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);
}
