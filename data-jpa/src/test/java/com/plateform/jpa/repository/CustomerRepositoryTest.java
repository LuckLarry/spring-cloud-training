package com.plateform.jpa.repository;

import com.plateform.jpa.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setBirth(new Date());
        customer.setCreateTime(new Date());
        customer.setName("customer");
        customerRepository.save(customer);

        Customer customer1 = new Customer();
        customer1.setBirth(new Date());
        customer1.setCreateTime(new Date());
        customer1.setName("customer1");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setBirth(new Date());
        customer2.setCreateTime(new Date());
        customer2.setName("customer2");
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setBirth(new Date());
        customer3.setCreateTime(new Date());
        customer3.setName("customer3");
        customerRepository.save(customer3);
    }


    @Test
    public void testFind(){
        Optional<Customer> customer = customerRepository.findById(1);
        System.out.println(customer.isPresent());
    }

    @Test
    public void testFindAll(){
        List<Customer> list = customerRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
        Assert.assertTrue(list.size()>0);
        log.info("all info {}",list);
    }

}