package com.plateform.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "pre_customer")
//@Table ：当实体类与映射的数据库表名不同名时需要使用 @Table 注解，该注解与 @Entity 注解并列使用，使用其 name 属性指明数据库的表名
@Entity
//@Entity ：修饰实体类，指明该类将映射到指定的数据表
public class Customer {

    @Id
//    @Id ：标识该属性为主键，一般标注在该属性的 getter 方法上
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue ：标注主键的生成策略，通过其 strategy 属性。通常与 @Id 注解一起使用。默认情况下 JPA 会自动选择一个最适合底层数据库的主键生成策略，MySQL 默认为 AUTO
    private Integer id;

    @Column(name = "user_name",nullable = false,length = 155)
//    @Column ：当实体的属性与其映射的数据表的列不同名时使用，一般用于 getter 方法上。其 name 属性用来指明此属性在数据表中对应的列名；unique 属性指明是否为唯一约束；nullable 属性用来指明是否可以为空，false 为不能为空；length 属性指明此列的长度。
    private String name;

    @Transient
//    @Transient ：标注此注解后在创建数据表的时候将会忽略该属性  Customer 类并没有 info 这个属性，所以数据库中也不应该有 info 这个字段
    private String info;

    @Temporal(TemporalType.DATE)
//    @Temporal ：向数据库映射日期（Date）属性时用来调整映射的精度。Date 类型的数据有 DATE, TIME, 和 TIMESTAMP 三种精度(即单纯的日期,时间,或者两者兼备)
//Birth 属性应该使用 DATE 类型(生日只具体到日即可，如：2015-10-22)，而 CreateTime 应该使用 TIMESTAMP 类型(创建时间应该具体到秒，如：2017-10-11 22:39:13)
    private Date birth;

//    @org.springframework.data.jpa.repository.Temporal(TemporalType.TIMESTAMP)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
