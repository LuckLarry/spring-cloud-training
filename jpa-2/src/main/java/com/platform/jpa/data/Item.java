package com.platform.jpa.data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "JPA_ITEMS")
@Entity
public class Item {
    private Integer id;
    private String itemName;
    private Set<Category> categories = new HashSet<>();

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "ITEM_NAME")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    //使用 @ManyToMany 注解来映射多对多关联关系
    // 使用 @JoinTable 来映射中间表
    // 1. name 指向中间表的名字
    // 2. joinColumns 映射当前类所在的表在中间表中的外键
    // 2.1 name 指定外键列的列名
    // 2.2 referencedColumnName 指定外键列关联当前表的哪一列
    // 3. inverseJoinColumns 映射关联的类所在中间表的外键
    //"ITEM_ID"和"CATEGORY_ID"是中间表中的列，referencedColumnName代表自己表的主键，referencedColumnName代表关联实体的主键
    @JoinTable(name = "ITEM_CATEGORY",
            joinColumns = {@JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

