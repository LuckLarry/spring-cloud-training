package com.platform.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//@Table(name = "T_product_info")
@Data
@Entity
public class ProductInfo {
    @Id
    private String productId;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private Integer productStatus;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
