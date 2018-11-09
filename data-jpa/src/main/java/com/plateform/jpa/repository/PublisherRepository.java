package com.plateform.jpa.repository;

import com.plateform.jpa.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
    Publisher findByName(String name);
}
