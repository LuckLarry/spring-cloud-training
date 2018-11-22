package com.plateform.jpa.object;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_department")
public class Department {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    private String name;

// 必注、必应主表 Student 属性 Department department;但是造成了JSON 死循环
//  @OneToMany(mappedBy="department")
//  private Set<Student> students=new HashSet<Student>();

//    public Department(){
//        super();
//    }
}
