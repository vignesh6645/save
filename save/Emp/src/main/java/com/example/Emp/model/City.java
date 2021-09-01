package com.example.Emp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="city_name")
    private String cityName;

    @OneToOne
    @JoinColumn(name="State_id_fk")
    private State stateid;
}
