package com.plateform.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookDetail {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @OneToOne(mappedBy = "bookDetail")
    @JoinColumn(name = "detailId")
    private Book book;

    public BookDetail() {
    }

    public BookDetail(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        if (null == book) {
            return String.format("Book [id=%s, name=%s, number of pages=%s]", id, "<EMPTY>");
        }

        return String.format("Book [id=%s, name=%s, number of pages=%s]", id,book.getId(),book.getName());
    }
}
