
package com.example.Emp.model;

        import lombok.Getter;
        import lombok.Setter;
        import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="state_name")
    private String stateName;

    @OneToOne
    @JoinColumn(name="country_id_fk")
    private Country countryid;
}
