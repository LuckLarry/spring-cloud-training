Spring Data JPA 之 一对一，一对多，多对多 关系映射
https://blog.csdn.net/johnf_nash/article/details/80642581


@JoinColumn 详解
https://blog.csdn.net/u010588262/article/details/76667283


关联查询（一对一、一对多、多对多）
https://www.cnblogs.com/hhhshct/p/9492741.html







mappedBy的意思就是“被映射”，即mappedBy这方不用管关联关系，关联关系交给另一方处理

如果两张表是以主键关联的，比如Person表主键是id，Address表主键是address_id，则运用如下注释：

@OneToOne(cascade={CascadeType.ALL})
@PrimaryKeyJoinColumn(name = "id", referencedColumnName="address_id") 
public Address getAddress( ) {
      return homeAddress;
}