package com.platform.order.controller;

import com.platform.order.client.ProductClient;
import com.platform.order.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        String response = productClient.productMsg();
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> list = productClient.listForOrder(Arrays.asList("234234234234234234","32452345234532452345"));
        log.info("res {}",list);
        return "res";
    }
}
