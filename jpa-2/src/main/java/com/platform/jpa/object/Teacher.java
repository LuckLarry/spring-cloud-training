package com.platform.jpa.object;

import lombok.Data;

import javax.management.remote.SubjectDelegationPermission;
import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Teacher implements Serializable {
    @Id
    @GeneratedValue
    private Integer teacherid;

    @Column(nullable = false,length = 32)
    private String name;

    //@ManyToMany注释表示Teacher是多对多关系的一端。
    //@JoinTable描述了多对多关系的数据表关系。name属性指定中间表名称，joinColumns定义中间表与Teacher表的外键关系。
    //中间表Teacher_Student的Teacher_ID列是Teacher表的主键列对应的外键列，inverseJoinColumns属性定义了中间表与另外一端(Student)的外键关系。
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name = "Teacher_Student",
        joinColumns = {@JoinColumn(name = "Teacher_ID",referencedColumnName = "teacherid")},
            inverseJoinColumns = {@JoinColumn(name = "Student_ID",referencedColumnName = "studentid")}
    )
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student){
        if(!this.students.contains(student)){
            this.students.add(student);
            student.setTeacher(this);
        }
    }

    public void removeStudent(Student student){
        if(this.students.contains(student)){
            student.setTeacher(null);
            this.students.remove(student);
        }
    }

}
