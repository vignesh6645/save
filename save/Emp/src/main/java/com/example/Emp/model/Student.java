package com.example.Emp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Student ")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="roll_no")
    private int rollNo;

    @Column(name="deparment")
    private String department;

    @Column(name="college")
    private String college;

    @OneToMany(mappedBy="person")
    private List<ParentsDetails> parentsDetails ;

    @OneToOne
    @JoinColumn(name="person_id_fk")
    private Person personId;

}
