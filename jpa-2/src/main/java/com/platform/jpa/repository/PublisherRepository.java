package com.platform.jpa.repository;

import com.platform.jpa.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository  extends JpaRepository<Publisher,Integer> {
    Publisher findByName(String name);
}
