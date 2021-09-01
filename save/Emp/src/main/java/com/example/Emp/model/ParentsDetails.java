package com.example.Emp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;



@Getter
@Setter
@Entity
@Table(name="ParentsDetails ")
public class ParentsDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="relationship")
    private String relationship;

    @Column(name="parent_occupation")
    private String parentOccupation;

    @ManyToOne
    @JoinColumn(name = "person_id_fk")
    private Person person;

    @OneToOne
    @JoinColumn(name="student_id_fk")
    private Student studentId;

}
