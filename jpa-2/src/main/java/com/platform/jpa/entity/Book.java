package com.platform.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name="publishId")
    private Publisher publisher;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publisher=" + publisher.getName() +
                '}';
    }

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }
}