package com.plateform.jpa.repository;

import com.plateform.jpa.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Integer>,
        PagingAndSortingRepository<Publisher,Integer>, JpaSpecificationExecutor<Publisher> {
    Publisher findByName(String name);
}
