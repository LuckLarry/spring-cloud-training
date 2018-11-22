package com.platform.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2018/8/16.
 */
@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="publishId",referencedColumnName = "id")
    private Set<Book> books;

    public Publisher() {
        super();
    }

    public Publisher(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books.size() +
                '}';
    }

}