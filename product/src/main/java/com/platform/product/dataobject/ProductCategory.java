package com.platform.product.dataobject;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer category_id;

    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

}
