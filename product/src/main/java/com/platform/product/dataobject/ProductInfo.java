package com.platform.product.dataobject;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Date;

//@Table(name = "T_product_info")
@Data
public class ProductInfo {
    private String productId;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private Integer ProductStatus;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
