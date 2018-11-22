package com.platform.jpa.repository;

import com.platform.jpa.data.Category;
import com.platform.jpa.data.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        Item i1 = new Item();
        i1.setItemName("i-1");
        Item i2 = new Item();
        i2.setItemName("i-2");
        Category c1 = new Category();
        c1.setCategoryName("C-1");
        Category c2 = new Category();
        c2.setCategoryName("C-2");
        //设置关联关系
        i1.getCategories().add(c1);
        i1.getCategories().add(c2);
        i2.getCategories().add(c1);
        i2.getCategories().add(c2);
        c1.getItems().add(i1);
        c1.getItems().add(i2);
        c2.getItems().add(i1);
        c2.getItems().add(i2);

        categoryRepository.save(c1);
        categoryRepository.save(c2);

        itemRepository.save(i1);
        itemRepository.save(i2);
    }


    @Test
    public void findByCategoryName() {
        Category category = categoryRepository.findByCategoryName("C-1");
        log.info("category ==>{}",category);
        log.info("category item ==>{}",category.getItems().size());
        Item item = itemRepository.findByItemName("i-1");
        log.info("item == >{}" ,item);

    }
}