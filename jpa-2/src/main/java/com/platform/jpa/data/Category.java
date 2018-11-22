package com.platform.jpa.data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "JPA_CATEGORIES")
@Entity
public class Category {
    private Integer id;
    private String categoryName;
    private Set<Item> items = new HashSet<>();

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "CATEGORY_NAME")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
