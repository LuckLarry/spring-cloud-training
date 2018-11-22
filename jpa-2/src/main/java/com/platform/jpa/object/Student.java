package com.platform.jpa.object;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private Integer studentid;

    @Column(nullable = false,length = 32)
    private String name ;

    //@ManyToMany注释表示Student是多对多关系的一边，mappedBy属性定义了Student为双向关系的维护端
    //Teacher表是关系的维护者，owner side，有主导权，它有个外键指向Student表。
    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers = new HashSet<>();

    public Student(){
        super();
    }

    public Student(String name){
        super();
        this.name = name;
    }

    public void setTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }
}
