package com.plateform.jpa.object;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Student() {
        super();
    }
}
