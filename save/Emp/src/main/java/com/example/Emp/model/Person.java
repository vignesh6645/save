package com.example.Emp.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Person ")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Column(name="address")
    private String address;

    @Column(name="blood_group")
    private String bloodGroup;

    @Column(name="email_id")
    private String emailId;

    @Column(name="mobile_number")
    private String mobile_number;

    @Column(name="fathers_name")
    private String fathersName;

    @Column(name="mothers_name")
    private String mothersName;
}
