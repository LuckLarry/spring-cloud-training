package com.platform.product.service;

import com.platform.product.dto.CartDTO;
import com.platform.product.ProductApplicationTests;
import com.platform.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void decreaseStock()throws  Exception{
        CartDTO cartDTO = new CartDTO("1231231231",2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}