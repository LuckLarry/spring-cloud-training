package com.platform.jpa.repository;

import com.platform.jpa.data.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<Item,Integer> {
    Item findByItemName(String name);
}
