package com.plateform.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    private String name ;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "detailId",referencedColumnName = "id")
    private BookDetail bookDetail;

    //注意 这里不能使用该属性，因为另一对于有Set<Book> books属性，造成死循环
    //关联属性id一般由多的一方取得（publishId）
//    @ManyToOne
//    @JoinColumn(name = "publishId")
//    private Publisher publisher;

    public Book(){
        super();
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, BookDetail bookDetail) {
        this.name = name;
        this.bookDetail = bookDetail;
    }

    @Override
    public String toString() {
        if (null == bookDetail) {
            return String.format("Book [id=%s, name=%s, number of pages=%s]", id, name, "<EMPTY>");
        }
        return String.format("Book [id=%s, name=%s, number of pages=%s]", id, name, bookDetail.getNumberOfPages());
    }

}
